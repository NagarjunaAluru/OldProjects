<#assign hasFieldErrors = parameters.name?? && fieldErrors?? && fieldErrors[parameters.name]??/>
<#if hasFieldErrors>
	<div class="errorBlock" style="color:#990000"> <#t/>
<#else>
<#assign hasAutoCompleteError = parameters.widgetname?? && fieldErrors?? && fieldErrors[parameters.widgetname]??/>
<#if hasAutoCompleteError>
	<div class="errorBlock" style="color:#990000"> <#t/>
</#if>
</#if>


<#if parameters.label??>
    <label <#t/>
<#if parameters.id??>
        for="${parameters.id?html}" <#t/>
</#if>
<#if !(parameters.required?default(true))>
	class="optional"
</#if>
><#t/>
${parameters.label?html}<#t/>
<#if !(parameters.required?default(true))>
	&nbsp;-&nbsp;optional<#t/>
</#if>
<#include "/${parameters.templateDir}/aloc/tooltip.ftl" /> 
</label><#t/>
</#if>

<#assign hasFieldErrors = parameters.name?? && fieldErrors?? && fieldErrors[parameters.name]??/>
<#if hasFieldErrors>
	<#list fieldErrors[parameters.name] as error>
	${error?html}
	<br /> <#t/>
	</#list>
<#else>
<#assign hasAutoCompleteError = parameters.widgetname?? && fieldErrors?? && fieldErrors[parameters.widgetname]??/>
<#if hasAutoCompleteError>
	<#list fieldErrors[parameters.widgetname] as error>
	${error?html}
	<br /> <#t/>
	</#list>
</#if>
</#if>