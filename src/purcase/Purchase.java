package purcase;

import java.util.Objects;

public class Purchase {
    private String title;
    private int count;

    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase purchase = (Purchase) o;
        return getCount() == purchase.getCount() && Objects.equals(getTitle(), purchase.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getCount());
    }
}

