import jakarta.annotation.Resource;
import jakarta.enterprise.concurrent.ManagedExecutorService;

public class JakartaEE11VirtualThreads {
    @Resource(lookup = "java:app/concurrent/myExecutor")
    private ManagedExecutorService managedExecutor;

    /*
     * Becomes:
     * @ManagedExecutorDefinition(name = "java:app/concurrent/myExecutor", maxAsync = 3, virtual = true)
     * private ManagedExecutorService managedExecutor;
     */

    public String longExecutingJob() {
        managedExecutor.submit(() -> {
            // do some long job
        });
        return "Job Submitted";
    }
}
