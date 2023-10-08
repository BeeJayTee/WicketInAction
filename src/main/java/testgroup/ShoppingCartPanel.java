package testgroup;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.text.NumberFormat;

public class ShoppingCartPanel extends Panel {
    private Cart cart;

    public ShoppingCartPanel(String id, Cart cart) {
        super(id);
        this.cart = cart;

        add(new ListView("cart", new PropertyModel
                (this, "cart.cheeses")) {
            @Override
            protected void populateItem(ListItem item) {
                Cheese cheese = (Cheese) item.getModelObject();
                item.add(new Label("name", cheese.getName()));
                item.add(new Label("price", "$" + cheese.getPrice()));
                item.add(new Link<Cheese>("remove", item.getModel()) {
                    @Override
                    public void onClick() {
                        Cheese selected = getModelObject();
                        System.out.println(getModelObject());
                        getCart().getCheeses().remove(selected);
                    }
                });
            }
        });

        add(new Label("total", new Model() {
            @Override
            public String getObject() {
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                return nf.format(getCart().getTotal());
            }
        }));
    }

    public Cart getCart() {
        return cart;
    }
}
