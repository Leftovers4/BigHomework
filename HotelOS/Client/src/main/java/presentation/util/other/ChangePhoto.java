package presentation.util.other;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.ResultMessage;

import java.io.*;

/**
 * Created by wyj on 2016/12/4.
 * Description: 用户更换图片的方法
 */
public class ChangePhoto {

    public static void updatePhoto(ImageView imageView, String photoPath) {
        Image image = new Image("file:///" + photoPath);
        imageView.setImage(image);
    }


    /**
     * 将file转换成byte[]
     * @param f
     * @return
     */
    public static byte[] toBytesFromFile(File f){
        if(f == null)
            return null;
        try {
            FileInputStream stream = new FileInputStream(f);

            ByteArrayOutputStream out = new ByteArrayOutputStream((int)f.length());
            byte[] b = new byte[(int)f.length()];
            int n;
            while((n = stream.read(b)) != -1){
                out.write(b, 0, n);
            }
            stream.close();
            out.close();
            return out.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 将图片写在本地特定路径
     * @param dirPath
     * @param id
     * @param imageBytes
     */
    public static void setImage(String dirPath, Object id, byte[] imageBytes) {

        // 若文件夹不存在，则创建
//        createDirIfNotExisted(dirPath);

        File imagePath = new File(dirPath);
        if(!imagePath.exists()){

            imagePath.mkdirs();
        }

        // 定位到该文件
        String path = dirPath + String.valueOf(id) + ".jpg";

        System.out.println(path);

        File image = new File(path);

        // 判断file是否已经存在
        if (!image.exists()){
            try {
                image.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 将byte[]转换成file
        try {

            FileOutputStream imageStream = new FileOutputStream(image);
            BufferedOutputStream brStream = new BufferedOutputStream(imageStream);
            brStream.write(imageBytes);

            brStream.close();
            imageStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
