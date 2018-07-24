//This is the title for your window tab, and your Radar
document.title = "| Test Engineering Radar | 2018 | \" To be the best test engineering team in Melbourne / Sydney \" |";


//This is the concentic circles that want on your radar
var radar_arcs = [
                   {'r':100,'name':'Adopt'}
                  ,{'r':200,'name':'Trial'}
                  ,{'r':300,'name':'Assess'}
                  ,{'r':400,'name':'Hold'}
                 // ,{'r':500,'name':'Possible Extra if you want it'}
                 ];

//This is your raw data
//
// Key
//
// movement:
//   t = moved
//   c = stayed put
//
// blipSize: 
//  intValue; This is optional, if you omit this property, then your blip will be size 70.
//            This give you the ability to be able to indicate information by blip size too
//
// url:
// StringValue : This is optional, If you add it then your blips will be clickable to some URL
//
// pc: polar coordinates
//     r = distance away from origin ("radial coordinate")
//     - Each level is 100 points away from origin
//     t = angle of the point from origin ("angular coordinate")
//     - 0 degrees is due east
//
// Coarse-grained quadrants
// - Techniques: elements of a software development process, such as experience design; and ways of structuring software, such micro-services.
// - Tools: components, such as databases, software development tools, such as versions control systems; or more generic categories of tools, such as the notion of polyglot persistance.
// - Platforms: things that we build software on top of: mobile technologies like Android, virtual platforms like the JVM, or generic kinds of platforms like hybrid clouds
// - Programming Languages and Frameworks
//
// Rings:
// - Adopt: blips you should be using now; proven and mature for use
// - Trial: blips ready for use, but not as completely proven as those in the adopt ring; use on a trial basis, to decide whether they should be part of your toolkit
// - Assess: things that you should look at closely, but not necessarily trial yet - unless you think they would be a particularly good fit for you
// - Hold: things that are getting attention in the industry, but not ready for use; sometimes they are not mature enough yet, sometimes they are irredeemably flawed
//      Note: there's no "avoid" ring, but throw things in the hold ring that people shouldn't use.

var h = 1000;
var w = 1200;

var radar_data = [
    { "quadrant": "Techniques",
        "left" : 45,
        "top" : 18,
        "color" : "#8FA227",
        "items" : [ 
			
			//ADOPT
			{"name":"Single Repository", "pc":{"r":50,"t":120},"movement":"c","url":"https://stash.aws.beteasy.com.au:8443/projects/CA/repos/crownbet.endtoendtests/browse"}, 
            {"name":"Bug Bash", "pc":{"r":80,"t":100},"movement":"c","url":"https://conflu.beteasy.be/display/DEL/Bug+Bash+Home"},   
            {"name":"Testing Pyramid", "pc":{"r":80,"t":150},"movement":"c","url":"https://conflu.beteasy.be/display/DEL/Testing+Pyramid"},   
            {"name":"TE on a Page", "pc":{"r":80,"t":130},"movement":"c","url":"https://conflu.beteasy.be/display/DEL/Test+Engineering+on+a+page"},
			
			//ASSESS
            //{ name: 'Git flow / Pull Requests ^', pc: { r: 230, t: 133 }, movement: 'c' },
            {"name":"Contract based testing", "pc":{"r":250,"t":165},"movement":"c"},    
            {"name":"Headless", "pc":{"r":225,"t":120},"movement":"c"},
            {"name":"Mobile Devices Wall", "pc":{"r":280,"t":110},"movement":"c"}, 
            {"name":"Continuous Experimentation", "pc":{"r":230,"t":110},"movement":"t"},
            {"name": 'Automation Refactoring ^', "pc": { r: 280, t: 133 }, movement: 'c' },
			
			
			//TRIAL
			{"name":"Sensible defaults", "pc":{"r":170,"t":150},"movement":"c"},   
            {"name":"Pair Programming", "pc":{"r":130,"t":170},"movement":"c"}, 
            {"name":"Lightweight Architecture Decision", "pc":{"r":170,"t":110},"movement":"c"},
            {"name":"Unit Testing Ownership", "pc":{"r":150,"t":95},"movement":"c"},
            {"name":"TDD", "pc":{"r":180,"t":105},"movement":"c"},   
            {"name":"Build Pipelines", "pc":{"r":180,"t":100},"movement":"c"},   
            {"name":"Static Analysis", "pc":{"r":130,"t":110},"movement":"t"},
            {"name":"Polygot Programming", "pc":{"r":180,"t":170},"movement":"t"},
            { name: 'Code Coverage', pc: { r: 180, t: 133 }, movement: 't' },
            {"name":"TestOps", "pc":{"r":180,"t":125},"movement":"t"},  
            //{"name":"Edge Services", "pc":{"r":130,"t":160},"movement":"c"}, 
            {"name":"Clean Code", "pc":{"r":130,"t":120},"movement":"t"},
            //{"name":"Wide and Thin Front-Ends", "pc":{"r":180,"t":160},"movement":"c"},
            //{"name":"Zookeeper for App Config", "pc":{"r":130,"t":130},"movement":"c"}, 
            //{"name":"Property based testing", "pc":{"r":130,"t":165},"movement":"c"},
            //{"name":"Evolutionary architecture", "pc":{"r":120,"t":95},"movement":"c"},
            {"name":"Code Reviews", "pc":{"r":110,"t":110},"movement":"c"},
            {"name":"Storybook / LOKI", "pc":{"r":130,"t":150},"movement":"c"},
			
			//HOLD
			{"name":"Ideation Platform", "pc":{"r":320,"t":170},"movement":"c"},
			{"name":"Testathon", "pc":{"r":330,"t":120},"movement":"t"},
			{"name":"Testing Newsletter", "pc":{"r":320,"t":110},"movement":"c"},	
			{"name":"Chaos Engineering", "pc":{"r":340,"t":130},"movement":"t"},
			{"name":"Polyglot", "pc":{"r":340,"t":100},"movement":"t"},
			{"name":"Machine Learning", "pc":{"r":360,"t":150},"movement":"t"}
			

        ]
    },
    { "quadrant": "Tools",
        "left": w-200+30,
        "top" : 18,
        "color" : "#587486",
        "items" : [ 
		
		
			//ADOPT
			{ name: 'Xray ^',    pc: { r: 80, t: 56 },    movement: 'c' },
			{ name: 'Stash/Git',    pc: { r: 12, t: 25 },    movement: 'c',    domain: 'back-end' },
			{ name: '.NET Core',    pc: { r: 30, t: 72 },    movement: 'c',    domain: 'back-end' },
			{ name: 'Pupeteer',    pc: { r: 80, t: 6 },    movement: 'c' },
			{ name: 'Serilog',    pc: { r: 80, t: 46 },    movement: 'c' },
			{ name: 'Jenkins',    pc: { r: 80, t: 76 },    movement: 'c' },
			{ name: 'XUnit',    pc: { r: 70, t: 26 },    movement: 'c' },
			{ name: 'RestSharp',    pc: { r: 60, t: 46 },    movement: 'c' },
			{ name: 'SQL Server',    pc: { r: 60, t: 66 },    movement: 'c' },
			{ name: 'PostgreS',    pc: { r: 40, t: 46 },    movement: 'c' },
			{ name: 'Core Java / JS',    pc: { r: 50, t: 26 },    movement: 'c' },
			{ name: 'Entityy Framework',    pc: { r: 80, t: 26 },    movement: 'c' },
			
			//TRIAL
		    { name: 'PACT',    pc: { r: 150, t: 69 },    movement: 'c' },
		    { name: 'Appium Studio',    pc: { r: 110, t: 70 },    movement: 'c' }, 
		    { name: 'BackstopJS',    pc: { r: 180, t: 66 },    movement: 'c' },
		    { name: 'SumoLogic',    pc: { r: 150, t: 14 },    movement: 'c' },
		    { name: 'AWS',    pc: { r: 180, t: 55 },    movement: 'c' },
		    { name: 'Hosted Graphite',    pc: { r: 120, t: 14 },    movement: 'c' },
			{ name: 'DynamoDB',    pc: { r: 160, t: 60 },    movement: 'c' },
			{ name: 'Postman',    pc: { r: 180, t: 5 },    movement: 'c' },
			  //{ name: 'Consul',    pc: { r: 170, t: 29 },    movement: 't' }, 
			   //{ name: 'Swagger Code-Gen',    pc: { r: 180, t: 82 },    movement: 'c' },
			   //{ name: 'PowerMock ^',    pc: { r: 180, t: 46 },    movement: 'c' },
			   //{ name: 'Mockito',    pc: { r: 170, t: 84 },    movement: 'c',    domain: 'back-end' },
			   //{ name: 'Json Web Tokens (JWT)',    pc: { r: 180, t: 77 },    movement: 'c' },
			   //{ name: 'Lemming',    pc: { r: 160, t: 82 },    movement: 'c' },
			   //{ name: 'Hystrix',    pc: { r: 150, t: 36 },    movement: 'c' },
			  //{ name: 'Git',    pc: { r: 130, t: 73 },    movement: 'c' },
	
			//ASSESS
			{ name: 'Docker',    pc: { r: 280, t: 74 },    movement: 'c' },  
			{ name: 'New Relic',    pc: { r: 280, t: 78 },    movement: 'c' },
			{ name: 'Trello',    pc: { r: 260, t: 75 },    movement: 't' },
			{ name: 'Cloud Watch',    pc: { r: 260, t: 48 },    movement: 't' },
			{ name: 'AWS SAM', pc: { r: 280, t: 51 }, movement: 't' },
			{ name: 'Serverless',    pc: { r: 280, t: 25 },    movement: 't' },
			{ name: 'LINUX',    pc: { r: 210, t: 31 },    movement: 'c' },
				
   		    //HOLD
			{ name: 'Jupter for Python ^',    pc: { r: 360, t: 82 },    movement: 't' },
			{ name: 'Tableau ^',    pc: { r: 380, t: 56 },    movement: 'c' },
			{ name: 'Performance Testing',    pc: { r: 330, t: 5 },    movement: 'c' }, 
			{ name: 'Kubernetes',    pc: { r: 330, t: 18 },    movement: 't' },
			{ name: 'Splunk',    pc: { r: 320, t: 28 },    movement: 't' },
			{ name: 'Kafka',    pc: { r: 370, t: 40 },    movement: 't' },
  
  ]
    },
    { "quadrant": "Domain",
        "left" :45,
         "top" : (h/2 + 18),
        "color" : "#DC6F1D",
        "items" : [
			
			
			//ADOPT
            {"name":"Domains Architecture", "pc":{"r":30,"t":225},"movement":"c","url":"https://conflu.beteasy.be/display/AR/Domains"},
            //{"name":"JVM as platform", "pc":{"r":90,"t":265},"movement":"c"},   
            //{"name":"AWS", "pc":{"r":90,"t":250},"movement":"c"},   
            //{ name: 'BigIP v11',              pc: { r: 50, t: 257 },              movement: 'c' },
			
			// TRIAL
           {"name":"Requirements Coverage - Stand Up", "pc":{"r":130,"t":260},"movement":"t"},   
           //{"name":"Location based services", "pc":{"r":130,"t":230},"movement":"c"},
           //{"name":"Openstack", "pc":{"r":190,"t":190},"movement":"c"},
           //  {"name":"RHEL 7", "pc":{"r":170,"t":215},"movement":"c"},      
			
			// ASSESS
            {"name":"Domain Champions", "pc":{"r":250,"t":260},"movement":"t"},
            {"name":"Bet Domain", "pc":{"r":275,"t":260},"movement":"c"},
            {"name":"Involve Product more", "pc":{"r":270,"t":195},"movement":"t"},
            {"name":"Client Domain", "pc":{"r":290,"t":265},"movement":"c"},   
            {"name":"Ledger Domain", "pc":{"r":290,"t":255},"movement":"t"},   
            //{"name":"Google as corporate platform", "pc":{"r":290,"t":200},"movement":"c"},   

			// HOLD
            //{"name":"Ruby On Rails", "pc":{"r":390,"t":215},"movement":"c"},
            //{"name":"Everest", "pc":{"r":390,"t":185},"movement":"c"},   
            //{"name":"Magnolia CMS", "pc":{"r":390,"t":235},"movement":"c"},   
            //{"name":"Java EE - the Bad Parts", "pc":{"r":390,"t":245},"movement":"c"},   
            //{"name":"MS SqlServer", "pc":{"r":390,"t":190},"movement":"c"},
            //{"name":"RHEL 5", "pc":{"r":370,"t":195},"movement":"c"}

        ]
    },
    { "quadrant": "People",
        "color" : "#B70062",
        "left"  : (w-200+30),
        "top" :   (h/2 + 18),
        "items" : [ 
		
			//ADOPT
            { name: 'Internal Tech meetups', pc: { r: 60, t: 330 },  movement: 'c',"url":"https://conflu.beteasy.be/display/DEL/Test+Tech+Meetup+Initiative"},
            { name: 'Community Of Testing Practice', pc: { r: 40, t: 310 },  movement: 'c', "url":"https://conflu.beteasy.be/display/DEL/Testing+COP"},
            { name: 'Yammer Group', pc: { r: 80, t: 300 },  movement: 'c', "url":"https://www.yammer.com/crownbet.com.au/#/threads/inGroup?type=in_group&feedId=11999845&view=all" },
			{ name: 'Testing / Automation Guild', pc: { r: 70, t: 345 },  movement: 'c', "url":"https://conflu.beteasy.be/display/DEL/Testing+Guild" },
            
			//TRIAL
			{ name: 'PDs - SDET - SET^', pc: { r: 150, t: 298 },              movement: 'c' },          
            {"name":"Champions", "pc":{"r":130,"t":355},"movement":"c"},   
            {"name":"T shape skills ^", "pc":{"r":190,"t":280},"movement":"c"},
			
			//ASSESS
            {"name":"Hosting meetups", "pc":{"r":280,"t":300},"movement":"c"},
            {"name":"IJP", "pc":{"r":290,"t":320},"movement":"t"},   
            {"name":"Skills Radar", "pc":{"r":220,"t":275},"movement":"c"},   
            {"name":"Speakers at Meetups/ Conferences", "pc":{"r":270,"t":282},"movement":"t"},
            {"name":"Early adopters", "pc":{"r":285,"t":330},"movement":"c"},   
            {"name":"Pluralsight", "pc":{"r":280,"t":310},"movement":"t"},
           // { name: 'RxJs',              pc: { r: 250, t: 338 },              movement: 'c',              domain: 'template' },
           // { name: 'Web Components', pc: { r: 260, t: 330 },  movement: 'c' },
			
			//HOLD
            { name: 'Team KRA / KPI ^', pc: { r: 360, t: 330 },  movement: 'c' },
            {"name":"Testathon", "pc":{"r":390,"t":290},"movement":"t"},
            {"name":"M shape skills", "pc":{"r":375,"t":330},"movement":"t"},
            //{"name":"Java 6 and earlier", "pc":{"r":390,"t":350},"movement":"c"}
        ]
    }
];
