package be.kdg.tagcustom.tags;

import be.kdg.tagcustom.model.Mandje;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ShowBasketTag extends SimpleTagSupport
{
    private Mandje basket;

    public void setBasket(Mandje basket)
    {
        this.basket = basket;
    }

    @Override
    public void doTag() throws JspException
    {
        try
        {
            JspWriter out = getJspContext().getOut();
            for (String film : basket.getAankopen())
            {
                out.println(film + "<br/>");
            }
        }
        catch (IOException e)
        {
            throw new JspException("cannot write to stream");
        }
    }
}