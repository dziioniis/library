/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-06-20 20:04:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.ServletException;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
        implements org.apache.jasper.runtime.JspSourceDependent {

    private static final javax.servlet.jsp.JspFactory _jspxFactory =
            javax.servlet.jsp.JspFactory.getDefaultFactory();

    private static java.util.Map<java.lang.String, java.lang.Long> _jspx_dependants;

    static {
        _jspx_dependants = new java.util.HashMap<java.lang.String, java.lang.Long>(1);
        _jspx_dependants.put("/jsp/css/log.css", Long.valueOf(1529170489980L));
    }

    private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
    private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;

    private javax.el.ExpressionFactory _el_expressionfactory;
    private org.apache.tomcat.InstanceManager _jsp_instancemanager;

    public java.util.Map<java.lang.String, java.lang.Long> getDependants() {
        return _jspx_dependants;
    }

    public void _jspInit() {
        _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
        _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
        _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
    }

    public void _jspDestroy() {
        _005fjspx_005ftagPool_005fc_005fchoose.release();
        _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    }

    public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
            throws java.io.IOException, javax.servlet.ServletException {

        final javax.servlet.jsp.PageContext pageContext;
        javax.servlet.http.HttpSession session = null;
        final javax.servlet.ServletContext application;
        final javax.servlet.ServletConfig config;
        javax.servlet.jsp.JspWriter out = null;
        final java.lang.Object page = this;
        javax.servlet.jsp.JspWriter _jspx_out = null;
        javax.servlet.jsp.PageContext _jspx_page_context = null;


        try {
            response.setContentType("text/html;charset=UTF-8");
            pageContext = _jspxFactory.getPageContext(this, request, response,
                    null, true, 8192, true);
            _jspx_page_context = pageContext;
            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();
            _jspx_out = out;

            out.write("\r\n");
            out.write("\r\n");
            out.write(" <html>\r\n");
            out.write("<head>\r\n");
            out.write("<title>LIBRARY</title>\r\n");
            out.write("</head>\r\n");
            out.write("\r\n");
            out.write("<style>\r\n");
            out.write("   ");
            out.write("body{\r\n");
            out.write("   background-image:url(/picture/images.jpg);\r\n");
            out.write("   background-size:cover;\r\n");
            out.write("   background-position:center;\r\n");
            out.write("    }\r\n");
            out.write(".login{\r\n");
            out.write("height:320;\r\n");
            out.write("width:290;\r\n");
            out.write("background:black;\r\n");
            out.write("border:1px double black;\r\n");
            out.write("border-radius:20px;\r\n");
            out.write("opacity:0.8;\r\n");
            out.write("position:absolute;\r\n");
            out.write(" right:40%;\r\n");
            out.write(" top:20%;\r\n");
            out.write(" padding:70px 30px;\r\n");
            out.write("\r\n");
            out.write("}\r\n");
            out.write("h1{\r\n");
            out.write("margin:0;\r\n");
            out.write("padding: 0 0 20px;\r\n");
            out.write("text-align:center;\r\n");
            out.write("color:white;\r\n");
            out.write("font-size:40px;\r\n");
            out.write("}\r\n");
            out.write("tr{\r\n");
            out.write("margin:0;\r\n");
            out.write("padding:0;\r\n");
            out.write("font-weight:bold;\r\n");
            out.write("color:white;\r\n");
            out.write("font-size:20;}\r\n");
            out.write("input{\r\n");
            out.write("width:100%;\r\n");
            out.write("margin-bottom:10px;\r\n");
            out.write("}\r\n");
            out.write("input[type=\"text\"], input[type=\"password\"],input[type=\"email\"]{\r\n");
            out.write("border:none;\r\n");
            out.write("background: transparent;\r\n");
            out.write("height: 20px;\r\n");
            out.write("background: #f2525;\r\n");
            out.write("border-bottom:1px solid #fff;\r\n");
            out.write("color:#fff;\r\n");
            out.write("}\r\n");
            out.write("input[type=\"submit\"]{\r\n");
            out.write("border:none;\r\n");
            out.write("height:25px;\r\n");
            out.write("border-radius:20px;\r\n");
            out.write("color:#fff;\r\n");
            out.write("background:grey;\r\n");
            out.write("}\r\n");
            out.write("input[type=\"submit\"]:hover{\r\n");
            out.write("    background-color:red;\r\n");
            out.write("}\r\n");
            out.write("h2{\r\n");
            out.write("padding:0;}\r\n");
            out.write("\r\n");
            out.write("\r\n");
            out.write("</style>\r\n");
            out.write("\r\n");
            out.write("<div  class=\"login\">\r\n");
            out.write("<h1>Login here</h1>\r\n");
            if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
                return;
            out.write("\r\n");
            out.write("\t\t<form action=\"servlet\" method=\"POST\">\r\n");
            out.write("\t\t<table>\r\n");
            out.write("\t\t<tr>\r\n");
            out.write("\t\t<td>username</td>\r\n");
            out.write("\t\t<td><input name=\"username\" type=\"text\" size=\"35\"  /></td>\r\n");
            out.write("\t\t</tr>\r\n");
            out.write("\t\t<td>password</td>\r\n");
            out.write("\t\t<td> <input name=\"password\" type=\"password\" size=\"35\" /></td>\r\n");
            out.write("\t\t</table>\r\n");
            out.write("\t\t\t\t\t<input type=\"hidden\" name=\"command\" value=\"login\">\r\n");
            out.write("\t\t\t\t\t<input type=\"submit\" name=\"submit\" />\r\n");
            out.write("\t\t</form>\r\n");
            out.write("\t\t<form action=\"servlet\" method=\"POST\">\r\n");
            out.write("\t\t<input type=\"hidden\" name=\"command\" value=\"goToRegister\"/>\r\n");
            out.write("\t\t<input type=\"submit\"  value=\"registration\" />\r\n");
            out.write("\t\t</form>\r\n");
            out.write("\t\t</div>\r\n");
            out.write("</body>\r\n");
            out.write("</html>\r\n");
        } catch (java.lang.Throwable t) {
            if (!(t instanceof javax.servlet.jsp.SkipPageException)) {
                out = _jspx_out;
                if (out != null && out.getBufferSize() != 0)
                    try {
                        out.clearBuffer();
                    } catch (java.io.IOException e) {
                    }
                if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
                else throw new ServletException(t);
            }
        } finally {
            _jspxFactory.releasePageContext(_jspx_page_context);
        }
    }

    private boolean _jspx_meth_c_005fchoose_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
            throws java.lang.Throwable {
        javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
        javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
        //  c:choose
        org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
        _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fchoose_005f0.setParent(null);
        int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
        if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
                out.write("\r\n");
                out.write("                       ");
                if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
                    return true;
                out.write("\r\n");
                out.write("                       ");
                if (_jspx_meth_c_005fwhen_005f1(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
                    return true;
                out.write("\r\n");
                out.write("                   ");
                int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
            } while (true);
        }
        if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
            return true;
        }
        _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
        return false;
    }

    private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
            throws java.lang.Throwable {
        javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
        javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
        //  c:when
        org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
        _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
        _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
        // /index.jsp(15,23) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.name =='admin'}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext) _jspx_page_context, null, false)).booleanValue());
        int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
        if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
                out.write("\r\n");
                out.write("                           ");
                if (true) {
                    _jspx_page_context.forward("/jsp/admin.jsp");
                    return true;
                }
                out.write("\r\n");
                out.write("                       ");
                int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
            } while (true);
        }
        if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
            return true;
        }
        _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
        return false;
    }

    private boolean _jspx_meth_c_005fwhen_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, javax.servlet.jsp.PageContext _jspx_page_context)
            throws java.lang.Throwable {
        javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
        javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
        //  c:when
        org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
        _jspx_th_c_005fwhen_005f1.setPageContext(_jspx_page_context);
        _jspx_th_c_005fwhen_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
        // /index.jsp(18,23) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
        _jspx_th_c_005fwhen_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.name != null}", java.lang.Boolean.class, (javax.servlet.jsp.PageContext) _jspx_page_context, null, false)).booleanValue());
        int _jspx_eval_c_005fwhen_005f1 = _jspx_th_c_005fwhen_005f1.doStartTag();
        if (_jspx_eval_c_005fwhen_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
                out.write("\r\n");
                out.write("                          ");
                if (true) {
                    _jspx_page_context.forward("/jsp/page/general.jsp");
                    return true;
                }
                out.write("\r\n");
                out.write("                       ");
                int evalDoAfterBody = _jspx_th_c_005fwhen_005f1.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
            } while (true);
        }
        if (_jspx_th_c_005fwhen_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
            return true;
        }
        _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f1);
        return false;
    }
}