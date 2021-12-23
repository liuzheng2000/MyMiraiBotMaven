package LoliconAPiTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HtmlDocument {
    public static void main(String[] args) {
        String html = "<!DOCTYPE html\n" +
                "\tPUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "\n" +
                "<head>\n" +
                "\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" +
                "\t<title>Sauce Found?</title>\n" +
                "\t<link rel=\"stylesheet\" href=\"css/saucenao-new.css\" media=\"screen\" type=\"text/css\" />\n" +
                "\t<script>\n" +
                "\t\t(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n" +
                "  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" +
                "  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n" +
                "  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\n" +
                "\n" +
                "  ga('create', 'UA-412819-5', 'saucenao.com');\n" +
                "  ga('send', 'pageview');\n" +
                "\n" +
                "\t</script>\n" +
                "\t<script>\n" +
                "\t\twindow.gnshbrequest = window.gnshbrequest || {cmd:[]};\n" +
                "\t\tgnshbrequest.cmd.push(function(){\n" +
                "\t\t\tgnshbrequest.registerPassback(\"1506500\");\n" +
                "\t\t\t\t\t});\n" +
                "\t</script>\n" +
                "\t<script async src=\"https://cpt.geniee.jp/hb/v1/198903/395/wrapper.min.js\"></script>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\t<!-- image/jpeg -->\n" +
                "\t<!-- descriptor generator response: success -->\n" +
                "\t<!-- adaptive minsim: 39.59 -->\n" +
                "\t<script type=\"text/javascript\">\n" +
                "\t\t// Add a script element as a child of the body\n" +
                "\t function downloadJSAtOnload() {\n" +
                "\t var jqueryelement = document.createElement(\"script\");\n" +
                "\t jqueryelement.src = \"scripts/static/jquery-1.5.min.js\";\n" +
                "\t document.body.appendChild(jqueryelement);\n" +
                "\t }\n" +
                "\t // Check for browser support of event handling capability\n" +
                "\t if (window.addEventListener)\n" +
                "\t window.addEventListener(\"load\", downloadJSAtOnload, false);\n" +
                "\t else if (window.attachEvent)\n" +
                "\t window.attachEvent(\"onload\", downloadJSAtOnload);\n" +
                "\t else window.onload = downloadJSAtOnload;\n" +
                "\t</script>\n" +
                "\n" +
                "\t<!-- <script type=\"text/javascript\" src=\"scripts/jquery-1.5.min.js\"></script> -->\n" +
                "\t<script type=\"text/javascript\">\n" +
                "\t\t//set max filesize to use for client side check\n" +
                "\tlocalStorage.setItem('fsizeMax',15);\n" +
                "\t\n" +
                "\tfunction showHidden(){\n" +
                "\t\t//enable blocked images\n" +
                "\t\t$('div.hidden').find('img[data-dly=\"1\"]').each(function(){\n" +
                "\t\t\tjQuery(this).attr('src',jQuery(this).attr('data-src'));\n" +
                "\t\t}).removeAttr('data-dly');\n" +
                "\t\t\n" +
                "\t\t//show hidden results\n" +
                "\t\t$('div.hidden').toggleClass('hidden');\n" +
                "\t\t$('#result-hidden-notification').toggleClass('hidden');\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction toggleHiddenImage(position){\n" +
                "\t\tvar resImage = document.getElementById(\"resImage\"+position)\n" +
                "\t\tif (resImage.hasAttribute(\"data-imgShowing\")){\n" +
                "\t\t\tresImage.removeAttribute(\"data-imgShowing\");\n" +
                "\t\t\tresImage.src = resImage.getAttribute('data-src');\n" +
                "\t\t}else{\n" +
                "\t\t\tresImage.setAttribute(\"data-imgShowing\",\"\");\n" +
                "\t\t\tresImage.src = resImage.getAttribute('data-src2');\n" +
                "\t\t}\n" +
                "\t}\n" +
                "\t\n" +
                "\tfunction followHiddenLink(elem){\n" +
                "\t\twindow.location.href = elem.getAttribute('data-href')\t\n" +
                "\t}\n" +
                "\t</script>\n" +
                "\t<script type=\"text/javascript\">\n" +
                "\t\tfunction hideMessage(){\n" +
                "\t\t$(\"#message\").hide(\"slow\");\n" +
                "\t\n" +
                "\t\tvar d = new Date();\n" +
                "\t\td.setTime(d.getTime()+(365*24*60*60*1000));\n" +
                "\t\tvar expires = \"expires=\"+d.toGMTString();\n" +
                "\t\tdocument.cookie = \"hide-message-2=1; \" + expires;\n" +
                "\t}\n" +
                "\t</script>\n" +
                "\t<div id=\"headerarea\">\n" +
                "\t\t<div id=\"headerbar\">\n" +
                "\t\t\t<div id=\"headerbarleft\">\n" +
                "\t\t\t\t<span style='color: #AAAAAA;'>||||||||||||||||||||||||||||||||||||||||||||||||</span><span style='color: #444444;'>||</span><span style='color: #AA0000'> 96% funded</span>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div id=\"headerbarright\"><a href=\"user.php\">register/login</a></div>\n" +
                "\t\t\t<div id=\"headerbarmiddle\">\n" +
                "\t\t\t\t<div id=\"headerbarmiddle\">SauceNAO Needs Your Support, <a\n" +
                "\t\t\t\t\t\thref=\"user.php?page=account-upgrades\"><span style=\"color: #00aa00;\">Upgrade</span></a> or <a\n" +
                "\t\t\t\t\t\thref=\"donate.php\"><span style=\"color: #00aa00;\">Donate</span></a> Today!</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\n" +
                "\t<div id=\"mainarea\">\n" +
                "\t\t<div id=\"left\">\n" +
                "\t\t\t<div id=\"yourimagecontainer\">\n" +
                "\t\t\t\t<div id=\"yourimage\"><a\n" +
                "\t\t\t\t\t\thref=\"edit.php?f=1&image=jETZ2Gg5q.jpg&amp;url=https%253A%252F%252Fimg3.gelbooru.com%252F%252Fsamples%252F88%252Fd6%252Fsample_88d63e7fa3facaaa73bd4ea1d4da7991.jpg\"><img title=\"Click to Edit Your Image\" alt=\"\" src=\"userdata/jETZ2Gg5q.jpg.png\" border=\"0\" /></a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<div id=\"yourimagetext\"><img alt=\"\" src=\"images/static/yourimage270.png\"/></div>\n" +
                "\t\t\t\t\t<div id=\"yourimageretrylinks\">\n" +
                "\t\t\t\t\t\t<a\n" +
                "\t\t\t\t\t\t\thref=\"https://www.google.com/searchbyimage?image_url=https%3A%2F%2Fimg3.gelbooru.com%2F%2Fsamples%2F88%2Fd6%2Fsample_88d63e7fa3facaaa73bd4ea1d4da7991.jpg&safe=off\"><img title=\"Search Google\" alt=\"\" src=\"images/static/siteicons/google.ico\" width=\"16\" height=\"16\" border=\"0\"/></a>\n" +
                "\t\t\t\t\t\t\t<a\n" +
                "\t\t\t\t\t\t\t\thref=\"https://iqdb.org?url=https%3A%2F%2Fimg3.gelbooru.com%2F%2Fsamples%2F88%2Fd6%2Fsample_88d63e7fa3facaaa73bd4ea1d4da7991.jpg\"><img title=\"Search IQDB\" alt=\"\" src=\"images/static/siteicons/iqdb.ico\" width=\"16\" height=\"16\" border=\"0\"/></a>\n" +
                "\t\t\t\t\t\t\t\t<a\n" +
                "\t\t\t\t\t\t\t\t\thref=\"https://www.tineye.com/search/?url=https%3A%2F%2Fimg3.gelbooru.com%2F%2Fsamples%2F88%2Fd6%2Fsample_88d63e7fa3facaaa73bd4ea1d4da7991.jpg\"><img title=\"Search TinEye\" alt=\"\" src=\"images/static/siteicons/tineye.ico\" width=\"16\" height=\"16\" border=\"0\"/></a>\n" +
                "\t\t\t\t\t\t\t\t\t<a\n" +
                "\t\t\t\t\t\t\t\t\t\thref=\"https://trace.moe/?auto&url=https%3A%2F%2Fimg3.gelbooru.com%2F%2Fsamples%2F88%2Fd6%2Fsample_88d63e7fa3facaaa73bd4ea1d4da7991.jpg\"><img title=\"Search Trace.moe (Formerly WhatAnime.ga)\" alt=\"\" src=\"images/static/siteicons/whatanime.ico\" width=\"16\" height=\"16\" border=\"0\"/></a>\n" +
                "\t\t\t\t\t\t\t\t\t\t<a\n" +
                "\t\t\t\t\t\t\t\t\t\t\thref=\"https://ascii2d.net/search/url/https%3A%2F%2Fimg3.gelbooru.com%2F%2Fsamples%2F88%2Fd6%2Fsample_88d63e7fa3facaaa73bd4ea1d4da7991.jpg\"><img title=\"Search ascii2d\" alt=\"\" src=\"images/static/siteicons/ascii2d.ico\" width=\"16\" height=\"16\" border=\"0\"/></a>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://yandex.com/images/search?rpt=imageview&url=https%3A%2F%2Fimg3.gelbooru.com%2F%2Fsamples%2F88%2Fd6%2Fsample_88d63e7fa3facaaa73bd4ea1d4da7991.jpg\"><img title=\"Search Yandex\" alt=\"\" src=\"images/static/siteicons/yandex.ico\" width=\"16\" height=\"16\" border=\"0\"/></a>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<div align=\"center\"><br />\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"https://patreon.com/saucenao\"><img alt=\"Donate!\" src=\"/images/static/patreon_a.gif\" onmouseover=\"this.src='//saucenao.com/images/static/patreon_b.gif'\" onmouseout=\"this.src='/images/static/patreon_a.gif'\"></a>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<br /><br />We need your help!<br /><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"donate.php\"><img alt=\"Donate!\" src=\"//saucenao.com/images/static/btn_donate.png\"></a>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\n" +
                "\t\t\t<div id=\"right\">\n" +
                "\n" +
                "\t\t\t</div>\n" +
                "\n" +
                "\t\t\t<div id=\"middle\">\n" +
                "\t\t\t\t<div id=\"smalllogo\"><img alt=\"\" src=\"images/static/bannersmall.png\"/></div>\n" +
                "\t\t\t\t\t<div class=\"result\">\n" +
                "\t\t\t\t\t\t<table class=\"resulttable\">\n" +
                "\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t<td class=\"resulttableimage\">\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultimage\"><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\thref=\"https://saucenao.com/search.php?db=999&url=https%3A%2F%2Fimg3.saucenao.com%2Fbooru%2F8%2F8%2F88d63e7fa3facaaa73bd4ea1d4da7991_1.jpg%3Fauth%3DMefnVlI4e0QIo8fLBec07w%26exp%3D1640721600\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\"><img id=\"resImage0\" title=\"Index #12: Yande.re - 88d63e7fa3facaaa73bd4ea1d4da7991_1.jpg\" raw-rating=\"2\" src=\"https://img3.saucenao.com/booru/8/8/88d63e7fa3facaaa73bd4ea1d4da7991_1.jpg?auth=MefnVlI4e0QIo8fLBec07w&exp=1640721600\" border=\"0\"/></a>\n" +
                "\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t<td class=\"resulttablecontent\">\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultmatchinfo\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultsimilarityinfo\">93.40%</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultmiscinfo\"><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://danbooru.donmai.us/post/show/3771027\"><img src=\"images/static/siteicons/danbooru.ico\" width=\"16\" height=\"16\" border=\"0\" alt=\"\"/></a><br /><br style=\"line-height:2px;\" /><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://yande.re/post/show/607109\"><img src=\"images/static/siteicons/yandere.ico\" width=\"16\" height=\"16\" border=\"0\" alt=\"\"/></a><br /><br style=\"line-height:2px;\" /><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://gelbooru.com/index.php?page=post&s=view&id=5116523\"><img src=\"images/static/siteicons/gelbooru.ico\" width=\"16\" height=\"16\" border=\"0\" alt=\"\"/></a><br /><br style=\"line-height:2px;\" /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultcontent\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div class=\"resulttitle\"><strong>Creator: </strong>mafuyu\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t(chibi21)<br /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"resultcontentcolumn\"><strong>Source: </strong><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://twitter.com/1kurusk/status/1224279331125358593\">Twitter\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t@1kurusk</a><br /><strong>Material: </strong>original<br /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"resultcontentcolumn\"></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"result\" id=\"result-hidden-notification\" onclick=\"showHidden()\">Low similarity results\n" +
                "\t\t\t\t\t\thave been hidden. Click here to display them...</div>\n" +
                "\t\t\t\t\t<div class=\"result hidden\">\n" +
                "\t\t\t\t\t\t<table class=\"resulttable\">\n" +
                "\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t<td class=\"resulttableimage\">\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultimage\"><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\thref=\"https://saucenao.com/search.php?db=999&url=https%3A%2F%2Fimg1.saucenao.com%2Fres%2Fpixiv%2F3969%2Fmanga%2F39693416_p2.jpg%3Fauth%3Db18E-VR7fGZr-f7boEV1sA%26exp%3D1640721600\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\"><img id=\"resImage1\" title=\"Index #5: Pixiv Images - 39693416_p2.jpg\" raw-rating=\"1\" src=\"images/static/blocked.gif\" data-dly=\"1\" data-src=\"https://img1.saucenao.com/res/pixiv/3969/manga/39693416_p2.jpg?auth=b18E-VR7fGZr-f7boEV1sA&exp=1640721600\" border=\"0\"/></a>\n" +
                "\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t<td class=\"resulttablecontent\">\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultmatchinfo\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultsimilarityinfo\">38.59%</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultmiscinfo\"></div>\n" +
                "\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultcontent\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resulttitle\"><strong>【PAV】ひとつの思い立ち【交流】</strong><br /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div class=\"resultcontentcolumn\"><strong>Pixiv ID: </strong><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://www.pixiv.net/member_illust.php?mode=medium&illust_id=39693416\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\">39693416</a><span style='padding-left:10px;'><a href='https://saucenao.com/info.php?lookup_type=0&db=5&id=39693416'><img src='/images/static/saucenao_info.png' height='10px' width='10px'></a></span><br /><strong>Member: </strong><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://www.pixiv.net/member.php?id=343432\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\">鈴稀あわひと</a><span style='padding-left:10px;'><a href='https://saucenao.com/info.php?lookup_type=1&db=5&id=343432'><img src='/images/static/saucenao_info.png' height='10px' width='10px'></a></span><br /><br /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"result hidden\">\n" +
                "\t\t\t\t\t\t<table class=\"resulttable\">\n" +
                "\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t<td class=\"resulttableimage\">\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultimage\"><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\thref=\"https://saucenao.com/search.php?db=999&url=https%3A%2F%2Fimg3.saucenao.com%2FdA2%2F81719%2F817194882.jpg%3Fauth%3DaG9yxmgdNpQYEcv6w1bF1w%26exp%3D1640721600\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\"><img id=\"resImage2\" title=\"Index #34: deviantArt2 - 817194882.jpg\" raw-rating=\"1\" src=\"images/static/blocked.gif\" data-dly=\"1\" data-src=\"https://img3.saucenao.com/dA2/81719/817194882.jpg?auth=aG9yxmgdNpQYEcv6w1bF1w&exp=1640721600\" border=\"0\"/></a>\n" +
                "\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t<td class=\"resulttablecontent\">\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultmatchinfo\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultsimilarityinfo\">37.07%</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultmiscinfo\"></div>\n" +
                "\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultcontent\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resulttitle\"><strong>Inktober Day18 - Pirate</strong><br /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div class=\"resultcontentcolumn\"><strong>dA ID: </strong><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://deviantart.com/view/817194882\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\">817194882</a><br /><strong>Author: </strong><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://www.deviantart.com/plavigmaz\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\">PlaviGmaz</a><br /><br /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"result hidden\">\n" +
                "\t\t\t\t\t\t<table class=\"resulttable\">\n" +
                "\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t<td class=\"resulttableimage\">\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultimage\"><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\thref=\"https://saucenao.com/search.php?db=999&url=https%3A%2F%2Fimg1.saucenao.com%2Fres%2Fnhentai%2F269259%2520%25281399621%2529%2520--%2520COMIC%2520LO%25202019-05%2520%255BDigital%255D%2F300.jpg%3Fauth%3D69WKvQeiuAX0J4m77JYUkg%26exp%3D1640721600\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\"><img id=\"resImage3\" title=\"Index #18: H-Misc (nhentai) - 300.jpg\" raw-rating=\"3\" src=\"images/static/blocked.gif\" data-dly=\"1\" data-src=\"https://img1.saucenao.com/res/nhentai/269259%20%281399621%29%20--%20COMIC%20LO%202019-05%20%5BDigital%5D/300.jpg?auth=69WKvQeiuAX0J4m77JYUkg&exp=1640721600\" border=\"0\"/></a>\n" +
                "\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t<td class=\"resulttablecontent\">\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultmatchinfo\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultsimilarityinfo\">36.68%</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultmiscinfo\"></div>\n" +
                "\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultcontent\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resulttitle\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<strong>COMIC LO 2019-05 [Digital]</strong><br /><small>COMIC LO 2019年5月号 [DL版]</small><br /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div class=\"resultcontentcolumn\"><strong>Creator(s): </strong>ueda yuu,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tnoise, mdo-h, maeshima ryou, usakun, isawa nohri, ryoumoto hatsumi,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tatage, nekodanshaku, shiratama moti, yusa, kinomoto anzu, hayake,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tsabaku, yamaya oowemon, airandou,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tnadadekoko<br /><br /><small>COMIC LO 2019-05</small><br /><small>COMIC LO 2019年5月号</small><br /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"result hidden\">\n" +
                "\t\t\t\t\t\t<table class=\"resulttable\">\n" +
                "\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t<td class=\"resulttableimage\">\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultimage\"><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\thref=\"https://saucenao.com/search.php?db=999&url=https%3A%2F%2Fimg1.saucenao.com%2Fres%2Fpixiv%2F8052%2F80524466_p0_master1200.jpg%3Fauth%3DGH2otAb3vnIPG2INmBSiqg%26exp%3D1640721600\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\"><img id=\"resImage4\" title=\"Index #5: Pixiv Images - 80524466_p0_master1200.jpg\" raw-rating=\"1\" src=\"images/static/blocked.gif\" data-dly=\"1\" data-src=\"https://img1.saucenao.com/res/pixiv/8052/80524466_p0_master1200.jpg?auth=GH2otAb3vnIPG2INmBSiqg&exp=1640721600\" border=\"0\"/></a>\n" +
                "\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t<td class=\"resulttablecontent\">\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultmatchinfo\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultsimilarityinfo\">36.25%</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultmiscinfo\"></div>\n" +
                "\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultcontent\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resulttitle\"><strong>バッチ（テニスウェア）</strong><br /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div class=\"resultcontentcolumn\"><strong>Pixiv ID: </strong><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://www.pixiv.net/member_illust.php?mode=medium&illust_id=80524466\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\">80524466</a><span style='padding-left:10px;'><a href='https://saucenao.com/info.php?lookup_type=0&db=5&id=80524466'><img src='/images/static/saucenao_info.png' height='10px' width='10px'></a></span><br /><strong>Member: </strong><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://www.pixiv.net/member.php?id=405390\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\">ナハ78</a><span style='padding-left:10px;'><a href='https://saucenao.com/info.php?lookup_type=1&db=5&id=405390'><img src='/images/static/saucenao_info.png' height='10px' width='10px'></a></span><br /><br /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"result hidden\">\n" +
                "\t\t\t\t\t\t<table class=\"resulttable\">\n" +
                "\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t<td class=\"resulttableimage\">\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultimage\"><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\thref=\"https://saucenao.com/search.php?db=999&url=https%3A%2F%2Fimg1.saucenao.com%2Fres%2Fpixiv_historical%2F964%2F9649975_s.jpg%3Fauth%3Drr4KiqsfIo7cCYzNPqAj5g%26exp%3D1640721600\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\"><img id=\"resImage5\" title=\"Index #6: Pixiv Historical - 9649975_s.jpg\" raw-rating=\"0\" src=\"images/static/blocked.gif\" data-dly=\"1\" data-src=\"https://img1.saucenao.com/res/pixiv_historical/964/9649975_s.jpg?auth=rr4KiqsfIo7cCYzNPqAj5g&exp=1640721600\" border=\"0\"/></a>\n" +
                "\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t<td class=\"resulttablecontent\">\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultmatchinfo\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultsimilarityinfo\">36.18%</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultmiscinfo\"></div>\n" +
                "\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultcontent\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resulttitle\"><strong>みてるよ</strong><br /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div class=\"resultcontentcolumn\"><strong>Old Pixiv ID: </strong><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://www.pixiv.net/member_illust.php?mode=medium&illust_id=9649975\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\">9649975</a><span style='padding-left:10px;'><a href='https://saucenao.com/info.php?lookup_type=0&db=6&id=9649975'><img src='/images/static/saucenao_info.png' height='10px' width='10px'></a></span><br /><strong>Member: </strong><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://www.pixiv.net/member.php?id=1174197\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\">グレンジャー</a><span style='padding-left:10px;'><a href='https://saucenao.com/info.php?lookup_type=1&db=6&id=1174197'><img src='/images/static/saucenao_info.png' height='10px' width='10px'></a></span><br /><br /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"result hidden\">\n" +
                "\t\t\t\t\t\t<table class=\"resulttable\">\n" +
                "\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t<td class=\"resulttableimage\">\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultimage\"><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\thref=\"https://saucenao.com/search.php?db=999&url=https%3A%2F%2Fimg1.saucenao.com%2Fres%2Fnhentai%2F211981%2520%25281131479%2529%2520--%2520%2528COMIC1%25E2%2598%258612%2529%2520%255BCrazy9%2520%2528Ichitaka%2529%255D%2520C9-31%2520Maid%2520Alter%2520ni%2520Gohoushi%2520Saretai%2520%2528Fate_Grand%2520Order%2529%2520%255BChinese%255D%2520%255B%25E7%25A9%25BA%25E6%25B0%2597%25E7%25B3%25BB%25E2%2598%2586%25E6%25BC%25A2%25E5%258C%2596%255D%2F12.jpg%3Fauth%3D97FTIP8xvKLk1elohHxX_g%26exp%3D1640721600\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\"><img id=\"resImage6\" title=\"Index #18: H-Misc (nhentai) - 12.jpg\" raw-rating=\"3\" src=\"images/static/blocked.gif\" data-dly=\"1\" data-src=\"https://img1.saucenao.com/res/nhentai/211981%20%281131479%29%20--%20%28COMIC1%E2%98%8612%29%20%5BCrazy9%20%28Ichitaka%29%5D%20C9-31%20Maid%20Alter%20ni%20Gohoushi%20Saretai%20%28Fate_Grand%20Order%29%20%5BChinese%5D%20%5B%E7%A9%BA%E6%B0%97%E7%B3%BB%E2%98%86%E6%BC%A2%E5%8C%96%5D/12.jpg?auth=97FTIP8xvKLk1elohHxX_g&exp=1640721600\" border=\"0\"/></a>\n" +
                "\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t<td class=\"resulttablecontent\">\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultmatchinfo\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultsimilarityinfo\">36.07%</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultmiscinfo\"></div>\n" +
                "\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultcontent\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resulttitle\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<strong>C9-31 Maid Alter ni Gohoushi Saretai</strong><br /><small>C9-31 メイドオルタにご奉仕されたいっ</small><br /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div class=\"resultcontentcolumn\"><strong>Creator(s): </strong>ichitaka,\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tcrazy9<br /><br /><small>(COMIC1☆12) [Crazy9 (Ichitaka)] C9-31 Maid Alter ni Gohoushi Saretai (Fate_Grand Order)</small><br /><small>(COMIC1☆12) [Crazy9 (いちたか)] C9-31 メイドオルタにご奉仕されたいっ (Fate/Grand Order)</small><br /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div class=\"result hidden\">\n" +
                "\t\t\t\t\t\t<table class=\"resulttable\">\n" +
                "\t\t\t\t\t\t\t<tr>\n" +
                "\t\t\t\t\t\t\t\t<td class=\"resulttableimage\">\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultimage\"><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\thref=\"https://saucenao.com/search.php?db=999&url=https%3A%2F%2Fimg1.saucenao.com%2Fres%2Fpixiv%2F5960%2F59600214_p0_master1200.jpg%3Fauth%3DJrYcTB8_0-HtKZ3zud_4eA%26exp%3D1640721600\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\"><img id=\"resImage7\" title=\"Index #5: Pixiv Images - 59600214_p0_master1200.jpg\" raw-rating=\"2\" src=\"images/static/blocked.gif\" data-dly=\"1\" data-src=\"https://img1.saucenao.com/res/pixiv/5960/59600214_p0_master1200.jpg?auth=JrYcTB8_0-HtKZ3zud_4eA&exp=1640721600\" border=\"0\"/></a>\n" +
                "\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t\t<td class=\"resulttablecontent\">\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultmatchinfo\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultsimilarityinfo\">35.91%</div>\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resultmiscinfo\"></div>\n" +
                "\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t\t<div class=\"resultcontent\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"resulttitle\"><strong>【リヴァエレ小説】表紙と通販のお知らせ</strong><br /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<div class=\"resultcontentcolumn\"><strong>Pixiv ID: </strong><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://www.pixiv.net/member_illust.php?mode=medium&illust_id=59600214\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\">59600214</a><span style='padding-left:10px;'><a href='https://saucenao.com/info.php?lookup_type=0&db=5&id=59600214'><img src='/images/static/saucenao_info.png' height='10px' width='10px'></a></span><br /><strong>Member: </strong><a\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\thref=\"https://www.pixiv.net/member.php?id=18179792\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\tclass=\"linkify\">パイロットランプ</a><span style='padding-left:10px;'><a href='https://saucenao.com/info.php?lookup_type=1&db=5&id=18179792'><img src='/images/static/saucenao_info.png' height='10px' width='10px'></a></span><br /><br /></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t\t\t</tr>\n" +
                "\t\t\t\t\t\t</table>\n" +
                "\t\t\t\t\t</div> <br />\n" +
                "\t\t\t\t\t<div style=\"text-align:center; margin-top:15px;\">\n" +
                "\t\t\t\t\t\t<div data-cptid=\"1506500\">\n" +
                "\t\t\t\t\t\t\t<script>\n" +
                "\t\t\t\t\t\t\t\tgnshbrequest.cmd.push(function() {\n" +
                "\t\t\t\t\t\t\tgnshbrequest.applyPassback(\"1506500\", \"[data-cptid='1506500']\");\n" +
                "\t\t\t\t\t\t  });\n" +
                "\t\t\t\t\t\t\t</script>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<div id=\"mainarea-expander\"></div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<div id=\"footerarea\">\n" +
                "\t\t\t\t<div id=\"footer-left\">\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<div id=\"footer-right\">\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<div id=\"footer-middle\">\n" +
                "\t\t\t\t\t<br /><br />\n" +
                "\t\t\t\t\t<p id=\"randomMessage\"><a href=\"https://addons.mozilla.org/en-US/firefox/addon/93451/\"\n" +
                "\t\t\t\t\t\t\tclass=\"style9\">~get the SauceNAO / IQDB firefox extension~</a></p>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\t\t\t\t\t<script type=\"text/javascript\">\n" +
                "\t\t\t\t\t\tfunction changeMessage() {\n" +
                "var numElements = 2;\n" +
                "var text = new Array(numElements);\n" +
                "text[0] = '<a href=\"tools/\" class=\"style9\">Get the Image Search Options Firefox and Chrome extensions!</a>';\n" +
                "text[1] = '<a href=\"http://twitter.com/#!/SauceNAO\" class=\"style9\">Don\\'t miss an update, follow us on Twitter!</a>';\n" +
                "var rand = Math.floor(Math.random()*numElements);\n" +
                "document.getElementById('randomMessage').innerHTML = text[rand];\n" +
                "}\n" +
                "\n" +
                "function toggleLayer( whichLayer )\n" +
                "{\n" +
                "  var elem, vis;\n" +
                "  if( document.getElementById ) // this is the way the standards work\n" +
                "    elem = document.getElementById( whichLayer );\n" +
                "  else if( document.all ) // this is the way old msie versions work\n" +
                "      elem = document.all[whichLayer];\n" +
                "  else if( document.layers ) // this is the way nn4 works\n" +
                "    elem = document.layers[whichLayer];\n" +
                "  vis = elem.style;\n" +
                "  // if the style.display value is blank we try to figure it out here\n" +
                "  if(vis.display==''&&elem.offsetWidth!=undefined&&elem.offsetHeight!=undefined)\n" +
                "    vis.display = (elem.offsetWidth!=0&&elem.offsetHeight!=0)?'block':'none';\n" +
                "  vis.display = (vis.display==''||vis.display=='block')?'none':'block';\n" +
                "}\n" +
                "\n" +
                "function togglenao()\n" +
                "{\n" +
                "\ttoggleLayer('advanced');\n" +
                "\ttoggleLayer('nonadvanced');\n" +
                "}\n" +
                "\t\t\t\t\t</script>\n" +
                "\n" +
                "\t\t\t\t\t<div id=\"Search\" style=\"\n" +
                "margin-left: auto;\n" +
                "margin-right: auto;\n" +
                "text-align:left;\n" +
                "width:375px;\">\n" +
                "\t\t\t\t\t\t<form action=\"search.php\" method=\"post\" enctype=\"multipart/form-data\">\n" +
                "\t\t\t\t\t\t\t<input type=\"file\" name=\"file\" id=\"file\" size=\"50\">\n" +
                "\t\t\t\t\t\t\t<input type=\"submit\" value=\"get sauce\" accesskey=\"s\">\n" +
                "\t\t\t\t\t\t\t<p align=\"center\"><a href=\"javascript:void(0)\" onClick=\"togglenao()\"\n" +
                "\t\t\t\t\t\t\t\t\tclass=\"style7\">~advanced options~</a>\n" +
                "\t\t\t\t\t\t\t\t<div id=\"advanced\" style=\"text-align:left; display:none;\">\n" +
                "\t\t\t\t\t\t\t\t\t<p>URL: <INPUT TYPE=\"TEXT\" NAME=\"url\" SIZE=\"40\">\n" +
                "</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t<p>Frame: <INPUT TYPE=\"TEXT\" NAME=\"frame\" VALUE=\"1\" SIZE=\"5\">\n" +
                "</p>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<p>Hide: <select name=\"hide\" size=\"1\">\n" +
                "  <option selected=\"selected\" value=\"0\">None</option>\n" +
                "  <option  value=\"1\">Known Explicit</option>\n" +
                "    <option  value=\"2\">Known and Suspected Explicit</option>\n" +
                "    <option  value=\"3\">All but Known Safe</option>\n" +
                "</select></p>\n" +
                "\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<p>Database: <select name=\"database\" size=\"1\">\n" +
                "<option selected=\"selected\" value=\"999\">All Databases</option>\n" +
                "  <option  value=\"0\">H-Magazines</option>\n" +
                "    <option  value=\"2\">H-Game CG</option>\n" +
                "    <option  value=\"3\">DoujinshiDB</option>\n" +
                "    <option  value=\"5\">pixiv Images</option>\n" +
                "\t  <option  value=\"8\">Nico Nico Seiga</option>\n" +
                "\t  <option  value=\"9\">Danbooru</option>\n" +
                "\t  <option  value=\"10\">drawr Images</option>\n" +
                "\t  <option  value=\"11\">Nijie Images</option>\n" +
                "\t  <option  value=\"12\">Yande.re</option>\n" +
                "\t  <option  value=\"15\">Shutterstock</option>\n" +
                "\t  <option  value=\"16\">FAKKU</option>\n" +
                "\t  <option  value=\"18\">H-Misc (nH)</option>\n" +
                "\t  <option  value=\"19\">2D-Market</option>\n" +
                "\t  <option  value=\"20\">MediBang</option>\n" +
                "\t  <option  value=\"21\">Anime</option>\n" +
                "\t  <option  value=\"22\">H-Anime</option>\n" +
                "\t  <option  value=\"23\">Movies</option>\n" +
                "\t  <option  value=\"24\">Shows</option>\n" +
                "\t  <option  value=\"25\">Gelbooru</option>\n" +
                "\t  <option  value=\"26\">Konachan</option>\n" +
                "\t  <option  value=\"27\">Sankaku Channel</option>\n" +
                "\t  <option  value=\"28\">Anime-Pictures.net</option>\n" +
                "\t  <option  value=\"29\">e621.net</option>\n" +
                "\t  <option  value=\"30\">Idol Complex</option>\n" +
                "\t  <option  value=\"31\">bcy.net Illust</option>\n" +
                "\t  <option  value=\"32\">bcy.net Cosplay</option>\n" +
                "\t  <option  value=\"33\">PortalGraphics.net (Hist)</option>\n" +
                "\t  <option  value=\"34\">deviantArt</option>\n" +
                "\t  <option  value=\"35\">Pawoo.net</option>\n" +
                "\t  <option  value=\"36\">Madokami (Manga)</option>\n" +
                "\t  <option  value=\"37\">MangaDex</option>\n" +
                "\t  <option  value=\"38\">H-Misc (eH)</option>\n" +
                "\t  <option  value=\"39\">ArtStation</option>\n" +
                "\t  <option  value=\"40\">FurAffinity</option>\n" +
                "\t  <option  value=\"41\">Twitter</option>\n" +
                "\t  <option  value=\"42\">Furry Network</option>\n" +
                "\t  <option value=\"999\">TBA...</option>\n" +
                "</select></p>\n" +
                "\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t</form>\n" +
                "\t\t\t\t\t\t<div id=\"nonadvanced\">\n" +
                "\t\t\t\t\t\t\t<p align=\"center\">&nbsp;</p>\n" +
                "\t\t\t\t\t\t\t<p align=\"center\">&nbsp;</p>\n" +
                "\t\t\t\t\t\t\t<p align=\"center\">&nbsp;</p>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<!-- QUERY INFO: -->\n" +
                "\t\t\t<!-- Index Search Time: 0.13259100914001 -->\n" +
                "\t\t\t<!-- DB Lookup Time: 0.018354892730713 -->\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        Document parse = Jsoup.parse(html);
        Element firstresulttable = parse.select("div#middle").select("table.resulttable").first();
        //图片地址
        Element element = firstresulttable.selectFirst("img#resImage0");
        //图片地址
        String Picture = element.attr("src");
        System.out.println(Picture);
        String xiangsidu = firstresulttable.selectFirst("div.resultsimilarityinfo").text();
        System.out.println(xiangsidu);
        String text = firstresulttable.selectFirst("div.resulttitle").text();
        System.out.println(text);
        String attr = firstresulttable.selectFirst("div.resultcontentcolumn").selectFirst("a").attr("href");
        System.out.println(attr);


    }
}
