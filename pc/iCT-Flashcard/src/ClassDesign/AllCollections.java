package ClassDesign;

public class AllCollections extends Collection {
	private Collection[] collection;
	
	private static AllCollections instance = new AllCollections();
	
	private AllCollections() {}
	
	public static AllCollections getAllCollections() {
		return instance;
	}

	public Collection[] getCollection() {
		return collection;
	}

	public void setCollection(Collection[] collection) {
		this.collection = collection;
	}
	
	

}
