<label<#rt/>
<#if parameters.id??>
 id="${parameters.id?html}"<#rt/>
</#if>
<#if !(parameters.required?default(true))>
	class="optional"
</#if>
<#if parameters.cssClass??>
 class="${parameters.cssClass?html}"<#rt/>
</#if>
<#if parameters.cssStyle??>
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
<#if parameters.title??>
 title="${parameters.title?html}"<#rt/>
</#if>
<#if parameters.for??>
 for="${parameters.for?html}"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
><#rt/>
<#if parameters.nameValue??>
<@s.property value="parameters.nameValue"/><#t/>
</#if>

<#if !(parameters.required?default(true))>
	&nbsp;-&nbsp;optional<#t/>
</#if>
<#include "/${parameters.templateDir}/aloc/tooltip.ftl" />
</label>