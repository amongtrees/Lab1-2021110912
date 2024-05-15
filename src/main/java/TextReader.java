import java.io.*;

public class TextReader {
    public void transformText(String fileLocation, String outputFile){
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(fileLocation);
            os = new FileOutputStream(outputFile);
            int size = is.available();
            char str;
            boolean flag = false; //is last char output a space?
            for (int i = 0; i <= size; i++){
                str = (char) is.read();
                if (str >= 'a' && str <= 'z'){
                    os.write(str);
                    flag = false;
                }
                else if(str >= 'A' && str <= 'Z'){
                    os.write((char)(str + 32));
                    flag = false;
                }
                else {
                    if ((!flag) && str==' '){
                        os.write(str);
                        flag = true;
                    } else if ((!flag) && (str == '\r' || str == '\n')) {
                        os.write(' ');
                        flag = true;
                    } else if ((!flag) && str >= 33 && str <= 47) {
                        os.write(' ');
                        flag = true;
                    }
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
            try{
                if (os != null) {
                    os.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
