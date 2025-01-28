package commons;

import okhttp3.*;

import java.io.IOException;
import java.util.Base64;

public class CaptchaSolver {

    private static final String API_KEY = "c19eeeee6c5ce4327e81adecc1eff000";

    public String getCaptchaSolution(String imageUrl) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String base64Image = convertImageToBase64(imageUrl);

        RequestBody formBody = new FormBody.Builder()
                .add("key", API_KEY)
                .add("method", "base64")
                .add("body", base64Image)
                .build();

        Request request = new Request.Builder()
                .url("http://2captcha.com/in.php")
                .post(formBody)
                .build();

        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();

        if (responseBody.contains("OK|")) {
            String captchaId = responseBody.split("\\|")[1];
            return getSolutionFrom2Captcha(captchaId);
        } else {
            System.out.println("Erro ao enviar CAPTCHA: " + responseBody);
            return null;
        }
    }

    private String getSolutionFrom2Captcha(String captchaId) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://2captcha.com/res.php?key=" + API_KEY + "&action=get&id=" + captchaId)
                .build();

        while (true) {
            Response response = client.newCall(request).execute();
            String responseBody = response.body().string();

            if (responseBody.contains("OK|")) {
                return responseBody.split("\\|")[1];
            } else if (responseBody.equals("CAPCHA_NOT_READY")) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Erro ao obter solução do CAPTCHA: " + responseBody);
                return null;
            }
        }
    }

    private String convertImageToBase64(String imageUrl) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(imageUrl).build();
        Response response = client.newCall(request).execute();
        byte[] imageBytes = response.body().bytes();
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
