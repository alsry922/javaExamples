package ch8;

import java.io.File;

public class ExceptionEx15 {
    public static void main(String[] args) {
        //command line에서 입력받은 값을 이름으로 갖는 파일을 생성한다.
        File file = createFile(args[0]);
        System.out.println(file.getName() + " 파일이 성공적으로 생성되었습니다.");
    }

    static File createFile(String fileName) {
        try {
            if (fileName == null || fileName.equals("")) {
                throw new Exception("파일 이름이 유효하지 않습니다.");
            }
        } catch (Exception e) {
            //fileName이 유효하지 않은 경우, 파일 이름을 '제목없음.txt'로 한다.
            fileName = "제목없음.txt";
        } finally {
            //File 클래스의 객체를 만든다
            File file = new File(fileName);
            //생성된 객체를 이용해서 파일을 생성한다.
            createNewFile(file);
            return file;
        }
    }

    static void createNewFile(File f) {
        try {
            // 파일을 생성한다.
            f.createNewFile();
        } catch (Exception e) {

        }
    }
}
