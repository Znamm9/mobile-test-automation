import java.util.Hashtable;

class TestClass2 implements Runnable {
    public void run() {
        Hashtable<String, String> capsHashtable = new Hashtable<String, String>();
        capsHashtable.put("browser", "chrome");
        capsHashtable.put("browser_version", "89.0");
        capsHashtable.put("os", "Windows");
        capsHashtable.put("os_version", "10");
        capsHashtable.put("build", "browserstack-build-1");
        capsHashtable.put("name", "Thread 2");
        mainTestClass r2 = new mainTestClass();
        r2.executeTest(capsHashtable);
    }
}