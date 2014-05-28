// @SOURCE:C:/Users/mohammed/WorkspacePlay/JmaghrebVoting/conf/routes
// @HASH:e2b5a7a95d5f6671b6303118171f324832e3cfad
// @DATE:Tue May 27 23:12:11 WEST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_login0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:7
private[this] lazy val controllers_Application_logout1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:8
private[this] lazy val controllers_Application_authenticate2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:10
private[this] lazy val controllers_Application_index3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:12
private[this] lazy val controllers_Application_getVoteStats4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("votes"))))
        

// @LINE:15
private[this] lazy val controllers_Application_saveVote5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("idSession/"),DynamicPart("idSession", """[^/]+""",true),StaticPart("/idVoter/"),DynamicPart("idVoter", """[^/]+""",true),StaticPart("/vote/"),DynamicPart("vote", """[^/]+""",true),StaticPart("/time/"),DynamicPart("time", """[^/]+""",true))))
        

// @LINE:18
private[this] lazy val controllers_Assets_at6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""POST""", prefix,"""controllers.Application.authenticate()"""),("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """votes""","""controllers.Application.getVoteStats()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """idSession/$idSession<[^/]+>/idVoter/$idVoter<[^/]+>/vote/$vote<[^/]+>/time/$time<[^/]+>""","""controllers.Application.saveVote(idSession:String, idVoter:String, vote:String, time:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_login0(params) => {
   call { 
        invokeHandler(controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Nil,"GET", """ Login page""", Routes.prefix + """login"""))
   }
}
        

// @LINE:7
case controllers_Application_logout1(params) => {
   call { 
        invokeHandler(controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:8
case controllers_Application_authenticate2(params) => {
   call { 
        invokeHandler(controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:10
case controllers_Application_index3(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """Home page                                   """, Routes.prefix + """"""))
   }
}
        

// @LINE:12
case controllers_Application_getVoteStats4(params) => {
   call { 
        invokeHandler(controllers.Application.getVoteStats(), HandlerDef(this, "controllers.Application", "getVoteStats", Nil,"GET", """""", Routes.prefix + """votes"""))
   }
}
        

// @LINE:15
case controllers_Application_saveVote5(params) => {
   call(params.fromPath[String]("idSession", None), params.fromPath[String]("idVoter", None), params.fromPath[String]("vote", None), params.fromPath[String]("time", None)) { (idSession, idVoter, vote, time) =>
        invokeHandler(controllers.Application.saveVote(idSession, idVoter, vote, time), HandlerDef(this, "controllers.Application", "saveVote", Seq(classOf[String], classOf[String], classOf[String], classOf[String]),"GET", """ Insert votes""", Routes.prefix + """idSession/$idSession<[^/]+>/idVoter/$idVoter<[^/]+>/vote/$vote<[^/]+>/time/$time<[^/]+>"""))
   }
}
        

// @LINE:18
case controllers_Assets_at6(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     