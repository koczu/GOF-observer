package pl.sternik.as.observer;

public final class TraderPanel {

    private static final int ILE_POZYCJI = 51;
    private static ServerStockDatas GPW_SERVER = new GpwServer();
    private static ServerStockDatas PROXY_ABONAMENT_KGH = new GpwServerSubscriptionController(GPW_SERVER, "KGH");
    private static ServerStockDatas PROXY_ABONAMENT_PKO = new GpwServerSubscriptionController(GPW_SERVER, "PKO");
    private final TickDisplayer tickDisplayer = new TickDisplayer();
    private final ShowPercentOfChange showPercentOfChange = new ShowPercentOfChange();

    private TraderPanel(ServerStockDatas server) {
        server.addObserver(tickDisplayer);
        server.addObserver(showPercentOfChange);
    }

    public static void main(String[] args) {

        new TraderPanel(TraderPanel.PROXY_ABONAMENT_KGH);
        new TraderPanel(TraderPanel.PROXY_ABONAMENT_PKO);
        for (int i = 0; i < ILE_POZYCJI; i++) {
            TraderPanel.PROXY_ABONAMENT_KGH.simulateTransaction();
        }

    }
}