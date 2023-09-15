
public class clearConsole {
	    public static void clearConsole() {
	        try {
	            if (System.getProperty("os.name").contains("Windows")) {
	                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	            } else {
	                System.out.print("\033[H\033[2J");
	                System.out.flush();
	            }
	        } catch (Exception e) {
	            System.out.println("Erro ao limpar o console: " + e);
	        }
	    }
	
}
