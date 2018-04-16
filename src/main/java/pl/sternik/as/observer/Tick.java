package pl.sternik.as.observer;

public class Tick {
    private final String name;
    private final double price;

    public Tick(String name, double price) {
        super();
        this.name = name;
        this.price = price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        final int displacement = 32;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> displacement));
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Tick other = (Tick) obj;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

	@Override
	public String toString() {
		return "Tick [name=" + name + ", price=" + price + "]";
	}
    
}
