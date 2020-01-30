animatedcollapse.addDiv('mainDiv', 'fade=0,speed=400,group=rsummary,hide=0')
animatedcollapse.addDiv('mainDiv2', 'fade=0,speed=400,group=rsummary,hide=0')

animatedcollapse.ontoggle=function($, divobj, state){ //fires each time a DIV is expanded/contracted
	//$: Access to jQuery
	//divobj: DOM reference to DIV being expanded/ collapsed. Use "divobj.id" to get its ID
	//state: "block" or "none", depending on state
}

animatedcollapse.init()