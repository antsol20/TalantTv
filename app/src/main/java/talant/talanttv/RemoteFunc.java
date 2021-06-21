package talant.talanttv;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class RemoteFunc{

    public static final Map<String, String> virgincodes = new HashMap() {{
        put("tv","LIVETV");
        put("select","SELECT");
        put("back","CLEAR");
        put("ch-up","CHANNELUP");
        put("ch-down","CHANNELDOWN");
        put("guide","GUIDE");
        put("menu","TIVO");
        put("up","UP");
        put("down","DOWN");
        put("left","LEFT");
        put("right","RIGHT");
        put("red","RED");
        put("green","GREEN");
        put("yellow","YELLOW");
        put("blue","BLUE");
        put("0","NUM0");
        put("1","NUM1");
        put("2","NUM2");
        put("3","NUM3");
        put("4","NUM4");
        put("5","NUM5");
        put("6","NUM6");
        put("7","NUM7");
        put("8","NUM8");
        put("9","NUM9");
        put("play","PLAY");
        put("pause","PAUSE");
        put("stop","STOP");
        put("record","RECORD");
        put("ffwd","FORWARD");
        put("rewind","REVERSE");
        put("replay","REPLAY");
        put("advance","ADVANCE");
    }};

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
    public static final Map<String, String> rokucodes = new HashMap() {{

        put("back","Back");
        put("search","Info");
        put("home","Home");
        put("select","Select");
        put("up","Up");
        put("down","Down");
        put("left","Left");
        put("right","Right");
        put("play","Play");

    }};



    public static final Map<String, String> matrixcodes = new HashMap() {{
        put("living_virgin","a55b02030100010000000000f9");
        put("bedroom_virgin","a55b02030100020000000000f8");
        put("kitchen_virgin","a55b02030100030000000000f7");
        put("loft_virgin","a55b02030100040000000000f6");

        put("living_freeview","a55b02030200010000000000f8");
        put("bedroom_freeview","a55b02030200020000000000f7");
        put("kitchen_freeview","a55b02030200030000000000f6");
        put("loft_freeview","a55b02030200040000000000f5");

        put("living_roku","a55b02030300010000000000f7");
        put("bedroom_roku","a55b02030300020000000000f6");
        put("kitchen_roku","a55b02030300030000000000f5");
        put("loft_roku","a55b02030300040000000000f4");

        put("living_mac","a55b02030400010000000000f6");
        put("bedroom_mac","a55b02030400020000000000f5");
        put("kitchen_mac","a55b02030400030000000000f4");
        put("loft_mac","a55b02030400040000000000f3");

    }};


    public static void doCode(int tab_number, final String str_cmd) {

        Thread bgThread = new Thread(() -> {
            try {
                sendRemCode(tab_number, str_cmd);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bgThread.start();
    }


    private static void sendRemCode(int tab_number, String str_cmd) throws IOException {

        if (tab_number == 1) {

            String thecode = "IRCODE " +  virgincodes.get(str_cmd) + "\r\n";
            byte[] b = thecode.getBytes(StandardCharsets.US_ASCII);

            Socket socket;
            socket = new Socket("192.168.1.38", 31339);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            OutputStream dout = socket.getOutputStream();

            dout.write(b);
            dout.flush();
            socket.close();
            dout.close();
            dis.close();
        }

        if (tab_number == 2) {

            String url = "http://192.168.1.44:8060/keypress/" + rokucodes.get(str_cmd);

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            String urlParameters = "";
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            con.getResponseCode();
            con.disconnect();

        }

        if (tab_number == 3) {

            Socket socket;
            socket = new Socket("192.168.1.19", 8000);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            OutputStream dout = socket.getOutputStream();

            dout.write(hexStringToByteArray(matrixcodes.get(str_cmd)));
            dout.flush();
            socket.close();
            dout.close();
            dis.close();
        }

    }
}
