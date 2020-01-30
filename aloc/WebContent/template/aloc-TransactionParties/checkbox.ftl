
<#assign hasFieldErrors = parameters.name?? && fieldErrors?? && fieldErrors[parameters.name]??/>
<#if hasFieldErrors>
	<div class="errorBlock" style="color:#990000"> <#t/>
</#if>

<#if parameters.title??><#t/>
	<p>${parameters.title}</p>
	<p>&nbsp;</p>
</#if><#t/>

<#assign hasFieldErrors = parameters.name?? && fieldErrors?? && fieldErrors[parameters.name]??/>
<#if hasFieldErrors>
	<#list fieldErrors[parameters.name] as error>
	${error?html}
	<br /> <#t/>
	</#list>
</#if>
<label for="${parameters.id?html}" <#rt/>
<#if parameters.cssClass??>
 class="${parameters.cssClass?html}"<#rt/>
</#if>
 style="width: 300px;"
>
<#if parameters.label?? && parameters.labelposition?default("right") == 'left'>
${parameters.label?html}<#t/>
<#include "/${parameters.templateDir}/aloc/tooltip.ftl" /> 
</#if>
<#include "/${parameters.templateDir}/simple/checkbox.ftl" />
<#if parameters.label?? && parameters.labelposition?default("right") == 'right'>
${parameters.label?html}<#t/>
<#include "/${parameters.templateDir}/aloc/tooltip.ftl" /> 
</#if>
</label>

<#include "/${parameters.templateDir}/aloc/controlfooter.ftl" />