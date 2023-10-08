package testgroup;

import org.apache.wicket.markup.html.WebPage;

import java.util.Arrays;
import java.util.List;

public abstract class CheesrPage extends WebPage {
    public CheesrSession getCheesrSession() {
        return (CheesrSession) getSession();
    }

    public Cart getCart() {
        return getCheesrSession().getCart();
    }

    public List<Cheese> getCheeses() {
        return CheesrApplication.get().getCheeses();
    }
}
