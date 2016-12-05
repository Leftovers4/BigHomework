package data.datahelper;

import util.ResultMessage;

import java.io.*;

/**
 * Created by Hiki on 12/5/2016.
 */
public class ImageHelperParent {

    protected byte[] findImageByID(String dirPath, Object id){

        // 定位到该文件
        String path = dirPath + String.valueOf(id) + ".jpg";

        // 打开文件
        File image = new File(path);
        return toBytesFromFile(image);

    }



    protected ResultMessage setImage(String dirPath, Object id, byte[] imageBytes) {

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
            return ResultMessage.Fail;
        }


        return ResultMessage.Success;

    }




    /**
     * 将file转换成byte[]
     * @param f
     * @return
     */
    private static byte[] toBytesFromFile(File f){
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
     * 创建文件夹
     * @param path
     */
    protected void createDirIfNotExisted(String path){
        // 创建文件夹
        File imagePath = new File(path);
        if(!imagePath.exists()){
            imagePath.mkdir();
        }
    }


}
