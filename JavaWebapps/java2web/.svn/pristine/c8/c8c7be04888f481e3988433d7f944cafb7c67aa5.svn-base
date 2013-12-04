/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.tags.tagtester;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author wouter
 */
public class TestTagHandler extends SimpleTagSupport
{
    private String test;
    private String test2;
    private String[] namen = {"Jos","Louie","Frans","Josefien","Wilhelmina"};

    /**
     * Called by the container to invoke this tag. 
     * The implementation of this method is provided by the tag library developer,
     * and handles all tag processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException
    {
        JspWriter out = getJspContext().getOut();
        
        try
        {
            out.write("Attribuut 1: " + test);
            out.write("<p>Nu volgt de body van uw Custom Tag:</p>");
            out.write("<div style=\"border:solid 1px;background:#CCCCCC;\" >");
            JspFragment f = getJspBody();
            if (f != null)
            {
                for(int i=0; i < namen.length; i++)
                {                    
                    this.getJspContext().setAttribute("naam", namen[i]);
                    f.invoke(out);
                }
            }
            out.write("</div>");
            out.write("Attribuut 2: " + test2);
            
        } catch (java.io.IOException ex)
        {
            throw new JspException("Error in TestTagHandler tag", ex);
        }
    }

    public void setTest(String test)
    {
        this.test = test;
    }

    public void setTest2(String test2)
    {
        this.test2 = test2;
    }
}
