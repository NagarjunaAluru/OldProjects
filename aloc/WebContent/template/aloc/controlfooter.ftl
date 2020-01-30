<#assign hasFieldErrors = parameters.name?? && fieldErrors?? && fieldErrors[parameters.name]??/>
<#if hasFieldErrors>
</div> <#t/>

<#else>
<#assign hasAutoCompleteError = parameters.widgetname?? && fieldErrors?? && fieldErrors[parameters.widgetname]??/>
<#if hasAutoCompleteError>
</div> <#t/>

</#if>
</#if>