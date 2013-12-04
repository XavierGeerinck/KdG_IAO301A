package be.kdg.tagcustom.tags;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectFromItemsTag extends SimpleTagSupport
{
    private String selectUrl;
    private Collection items;

    public void setSelectUrl(String selectUrl)
    {
        this.selectUrl = selectUrl;
    }

    public void setItems(Collection items)
    {
        this.items = items;
    }

    @Override
    public void doTag() throws JspException
    {
        try
        {
            JspWriter out = getJspContext().getOut();
            out.println("<form action=\"" + selectUrl + "\" method=\"post\">");
            for (Object item : items)
            {
                out.println("<input type=\"radio\" name=\"item\" value=\"" + item + "\"/>" + item + "<br/>");
            }
            out.println("<input type=\"submit\" name=\"submit\" value=\"Koop\">");
            out.println("</form>");
        }
        catch (IOException e)
        {
            throw new JspException("cannot write to stream");
        }
    }
}
