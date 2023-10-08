package testgroup;

import org.apache.wicket.Application;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see testgroup.Start#main(String[])
 */
public class CheesrApplication extends WebApplication
{

	private List<Cheese> cheeses = Arrays.asList(
			new Cheese("Gouda", "It's gouda", 1.65),
			new Cheese("Cheddar", "It's cheddar", 1.55),
			new Cheese("Boursin", "It's boursin", 1.45),
			new Cheese("Mozzarella", "It's mozzarella", 1.35),
			new Cheese("Parmesean", "It's parmesean", 1.25),
			new Cheese("Brie", "It's brie", 1.15));

	@Override
	public Session newSession(Request request, Response response) {
		return new CheesrSession(request);
	}

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return Index.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		// add your configuration here
		getCspSettings().blocking().disabled();
	}

	public static CheesrApplication get() {
		return (CheesrApplication) Application.get();
	}

	public List<Cheese> getCheeses() {
		return Collections.unmodifiableList(cheeses);
	}
}
