
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,List[Sessions],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String, sessions : List[Sessions]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.46*/("""

"""),_display_(Seq[Any](/*3.2*/main("Jmaghreb Voting System")/*3.32*/ {_display_(Seq[Any](format.raw/*3.34*/("""

      <div class="jumbotron">
      <div class="row">
    <div class="col-md-10 col-md-offset-2">
        <h1>Jmaghreb Voting System</h1>
        <p> This is just a simple application shown Jmaghreb voting System prototype ... </p>
        
            </div>
            <div class="col-md-10 col-md-offset-5">
            <h4> <a href="""),_display_(Seq[Any](/*13.27*/routes/*13.33*/.Application.logout())),format.raw/*13.54*/("""> Log out </a></h4>
            </div>
</div>
        </div>
 <div class="row">
    <div class="col-md-10 col-md-offset-2">
    <div class="col-xs-12 .col-md-8">
  
    <label>Please choos a session ID...</label>
    </div>
    <div class="col-xs-6">
     """),_display_(Seq[Any](/*24.7*/helper/*24.13*/.form(routes.Application.index)/*24.44*/ {_display_(Seq[Any](format.raw/*24.46*/("""
     <select class="form-control" name="sessionId" >
      <optgroup label="Sessions ID">
      """),_display_(Seq[Any](/*27.8*/for(s <- sessions) yield /*27.26*/{_display_(Seq[Any](format.raw/*27.27*/("""
     <option value=""""),_display_(Seq[Any](/*28.22*/s/*28.23*/.getSession())),format.raw/*28.36*/("""">"""),_display_(Seq[Any](/*28.39*/s/*28.40*/.getSession())),format.raw/*28.53*/("""</option>
   """)))})),format.raw/*29.5*/("""
      </optgroup>
  </select>
     </div>
     <div class="col-xs-6">
  <button type="submit" class="btn btn-default">Submit</button>
 """)))})),format.raw/*35.3*/("""
    </div>
    
     </div>
      <br>
      
     <canvas class="col-md-2 col-md-offset-2" id="chart" width="600" height="400"></canvas>
      <br>
</div></div></div>
   

    </div> <!-- /container -->
  
   
 <script>

 
		
var data = """),format.raw/*53.12*/("""{"""),format.raw/*53.13*/("""
			labels : ["Excellent","Good","Not bad"],
			datasets : [
				"""),format.raw/*56.5*/("""{"""),format.raw/*56.6*/("""
					fillColor : "rgba(220,220,220,0.5)",
					strokeColor : "rgba(220,220,220,1)",
					data : """),_display_(Seq[Any](/*59.14*/message)),format.raw/*59.21*/("""
				"""),format.raw/*60.5*/("""}"""),format.raw/*60.6*/("""
			]
			
		"""),format.raw/*63.3*/("""}"""),format.raw/*63.4*/(""";
	var myLine = new Chart(document.getElementById("chart").getContext("2d")).Bar(data);
	
	</script>
""")))})),format.raw/*67.2*/("""
"""))}
    }
    
    def render(message:String,sessions:List[Sessions]): play.api.templates.HtmlFormat.Appendable = apply(message,sessions)
    
    def f:((String,List[Sessions]) => play.api.templates.HtmlFormat.Appendable) = (message,sessions) => apply(message,sessions)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed May 28 01:44:51 WEST 2014
                    SOURCE: C:/Users/mohammed/WorkspacePlay/JmaghrebVoting/app/views/index.scala.html
                    HASH: 18ac246f1ac934dbdbe897822b6e01b20fdd6b06
                    MATRIX: 789->1|927->45|964->48|1002->78|1041->80|1417->420|1432->426|1475->447|1767->704|1782->710|1822->741|1862->743|1995->841|2029->859|2068->860|2126->882|2136->883|2171->896|2210->899|2220->900|2255->913|2300->927|2468->1064|2735->1303|2764->1304|2856->1369|2884->1370|3018->1468|3047->1475|3079->1480|3107->1481|3146->1493|3174->1494|3307->1596
                    LINES: 26->1|29->1|31->3|31->3|31->3|41->13|41->13|41->13|52->24|52->24|52->24|52->24|55->27|55->27|55->27|56->28|56->28|56->28|56->28|56->28|56->28|57->29|63->35|81->53|81->53|84->56|84->56|87->59|87->59|88->60|88->60|91->63|91->63|95->67
                    -- GENERATED --
                */
            