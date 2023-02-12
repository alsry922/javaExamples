package ch8;

public class ChainedExceptionEx {
    public static void main(String[] args) {
        try {
            install();
        } catch (InstallException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void install() throws InstallException{
        try {
            startInstall();
            copyFiles();
        } catch (SpaceException se) {
            InstallException ie = new InstallException("설치 중 예외발생");
            ie.initCause(se);
            throw ie;
        } catch (MemoryException me) {
            InstallException ie = new InstallException("설치 중 예외발생");
            ie.initCause(me);
            throw ie;
        } finally {
            deleteTempFiles();
        }
    }

    private static void startInstall() throws SpaceException, MemoryException{
        if (!enoughSpace()) {
            throw new SpaceException("설치할 공간이 부족합니다.");
        }
        if (!enoughMemory()) {
            throw new MemoryException("메모리가 부족합니다.");
        }
    }

    private static void copyFiles() {

    }

    private static void deleteTempFiles() {
    }

    private static boolean enoughSpace() {
        //대충 설치하는데 충분한 공간이 있는지 확인하는 코드
        return false;
    }

    private static boolean enoughMemory() {
        //대충 설치하는데 충분한 메모리 공간이 있는지 확인하는 코드
        return true;
    }

    static class InstallException extends Exception {
        InstallException(String msg) {
            super(msg);
        }
    }

    static class SpaceException extends Exception {
        SpaceException(String msg) {
            super(msg);
        }
    }

    static class MemoryException extends Exception {
        public MemoryException(String message) {
            super(message);
        }
    }
}



