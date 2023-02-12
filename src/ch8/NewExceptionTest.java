package ch8;

public class NewExceptionTest {
    public static void main(String[] args) {
        try {
            startInstall();
            copyFiles();
        } catch (SpaceException e) {
            System.out.println("에러 메세지 : " + e.getMessage());
            e.printStackTrace();
            System.out.println("공간을 확보한 후에 다시 설치하시기 바랍니다.");
        } catch (MemoryException me) {
            System.out.println("에러 메세지 : " + me.getMessage());
            me.printStackTrace();
            System.gc(); //Garbage Collection을 수행하여 메모리를 늘려준다.
            System.out.println("다시 설치를 시도하세요.");
        } finally {
            deleteTempFiles();
        }
    }

    private static void deleteTempFiles() {
        /*대충 임시 파일 삭제 코드*/
    }

    private static void copyFiles() {
        /*대충 파일 복사 코드*/
    }

    private static void startInstall() throws SpaceException, MemoryException{
        if (!enoughSpace()) { //충분한 설치 공간이 없으면
            throw new SpaceException("설치할 공간이 부족합니다.");
        }
        if (!enoughMemory()) { //충분한 메모리가 업스면
            throw new MemoryException("메모리가 부족합니다.");
        }
    }

    private static boolean enoughMemory() {
        return true;
    }

    private static boolean enoughSpace() {
        return false;
    }
}

class SpaceException extends Exception{
    SpaceException(String msg) {
        super(msg);
    }
}

class MemoryException extends Exception {
    MemoryException(String msg) {
        super(msg);
    }
}