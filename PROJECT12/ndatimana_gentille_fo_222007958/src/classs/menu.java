package classs;

public class menu {

	
	
	    private  int id;
	    private String price;
	    private String availlability;
		public menu(int id, String price, String availlability) {
			super();
			this.id = id;
			this.price = price;
			this.availlability = availlability;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getAvaillability() {
			return availlability;
		}
		public void setAvaillability(String availlability) {
			this.availlability = availlability;
		}
}