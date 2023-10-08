package testgroup;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.StringValidator;

public class CheckoutPage extends CheesrPage {
    public CheckoutPage() {
        add(new FeedbackPanel("feedback"));
        Form form = new Form("form");
        add(form);
        Address address = getCart().getBillingAddress();

        form.add(new TextField<PropertyModel>("name", new PropertyModel(address, "name"))
                .setRequired(true)
                .add(StringValidator.lengthBetween(5, 32))
        );
        form.add(new TextField<PropertyModel>("street", new PropertyModel(address, "street")).setRequired(true));
        form.add(new TextField<PropertyModel>("zipcode", new PropertyModel(address, "zipcode")).setRequired(true));
        form.add(new TextField<PropertyModel>("city", new PropertyModel(address, "city")).setRequired(true));

        form.add(new Link<>("cancel") {
            @Override
            public void onClick() {
                setResponsePage(Index.class);
            }
        });
        form.add(new Button("order") {
            @Override
            public void onSubmit() {
                Cart cart = getCart();

                cart.getCheeses().clear();
                setResponsePage(Index.class);
            }
        });

        add(new ShoppingCartPanel("shoppingcart", getCart()));
    }
}
