//
// Copyright (c) 2007 Spotfire AB,
// Första Långgatan 26, SE-413 28 Göteborg, Sweden.
// All rights reserved.
//
// This software is the confidential and proprietary information
// of Spotfire AB ("Confidential Information"). You shall not
// disclose such Confidential Information and shall use it only
// in accordance with the terms of the license agreement you
// entered into with Spotfire.
//


var spotfire = { webPlayer : {} };


//
// Enums
//
spotfire.webPlayer.errorCodes =
{
    /// <summary>Error code definitions. Used as argument to the <c>application.onError</c> event.</summary>
    /// <field name="ERROROPEN" type="spotfire.webPlayer.errorCodes">Error code for opening related errors.</field>
    /// <field name="ERRORCLOSE" type="spotfire.webPlayer.errorCodes">Error code for closing of analysis related errors.</field>
    /// <field name="ERRORBOOKMARK" type="spotfire.webPlayer.errorCodes">Error code for bookmark related errors.</field>
    /// <field name="ERRORFILTERING" type="spotfire.webPlayer.errorCodes">Error code for filtering related errors.</field>
    /// <field name="ERRORMARKING" type="spotfire.webPlayer.errorCodes">Error code for marking related errors.</field>
    /// <field name="ERRORPAGES" type="spotfire.webPlayer.errorCodes">Error code for page related errors.</field>
    /// <field name="ERRORINTERNAL" type="spotfire.webPlayer.errorCodes">Error code for internal errors.</field>
    /// <field name="ERRORDOCUMENT" type="spotfire.webPlayer.errorCodes">Error code for document related errors.</field>
        
    ERROROPEN:'ErrorOpen',
    ERRORCLOSE:'ErrorClose',
    ERRORBOOKMARK:'ErrorBookmark',
    ERRORFILTERING:'ErrorFiltering',
    ERRORMARKING:'ErrorMarking',
    ERRORPAGES:'ErrorPages',
    ERRORINTERNAL:'ErrorInternal',
    ERRORDOCUMENT:'ErrorDocument'
};

spotfire.webPlayer.markingOperation =
{
    /// <summary>Marking operation definitions. Used as argument to the <c>Marking.setMarking</c> function.</summary>
    /// <field name="REPLACE" type="spotfire.webPlayer.markingOperation">Replaces the given marking with the new conditions specified in the where clause.</field>
    /// <field name="ADD" type="spotfire.webPlayer.markingOperation">Add rows from the specified where clause to the given marking.</field>
    /// <field name="SUBTRACT" type="spotfire.webPlayer.markingOperation">Removes rows from the specified where clause in the given marking.</field>
    /// <field name="TOGGLE" type="spotfire.webPlayer.markingOperation">Toggles between the current marking and the result of the specified where clause.</field>
    /// <field name="INTERSECT" type="spotfire.webPlayer.markingOperation">Intersects the current marking with the marking specified in the where clause.</field>
    /// <field name="CLEAR" type="spotfire.webPlayer.markingOperation">Clears the given marking. The where clause will be ignored.</field>
    
    REPLACE:'Replace',
    ADD:'Add',
    SUBTRACT:'Subtract',
    TOGGLE:'Toggle',
    INTERSECT:'Intersect',
    CLEAR:'Clear'
};

spotfire.webPlayer.filteringOperation =
{
    /// <summary>Filtering operation definitions. Used as argument to the <c>FilterSettings.operation</c> property.</summary>
    /// <field name="ADD" type="spotfire.webPlayer.filteringOperation">Adds values specified in a spotfire.webPlayer.FilterSettings object to the filter.</field>
    /// <field name="REMOVE" type="spotfire.webPlayer.filteringOperation">Removes values specified in a spotfire.webPlayer.FilterSettings object to the filter.</field>
    /// <field name="REPLACE" type="spotfire.webPlayer.filteringOperation">Replaces all values in the filter with the ones specified in a spotfire.webPlayer.FilterSettings object. If the values contains invalid values, the operation will add all valid values and report an error message with the failed ones.</field>
    /// <field name="ADD_ALL" type="spotfire.webPlayer.filteringOperation">Adds all values to the filter. The values property in spotfire.webPlayer.FilterSettings must not be set.</field>
    /// <field name="REMOVE_ALL" type="spotfire.webPlayer.filteringOperation">Removes all values from the filter. The values property in spotfire.webPlayer.FilterSettings must not be set.</field>
    /// <field name="RESET" type="spotfire.webPlayer.filteringOperation">Resets the filter to its default state.</field>
    
    ADD:'Add',
    REMOVE:'Remove',
    REPLACE:'Replace',
    ADD_ALL:'AddAll',
    REMOVE_ALL:'RemoveAll',
    RESET:'Reset'
};

spotfire.webPlayer.includedFilterSettings =
{
    /// <summary>Defines what settings to include when getting filter columns.</summary>
    /// <field name="NONE" type="spotfire.webPlayer.includedFilterSettings">Do not include any filter settings.</field>
    /// <field name="ALL_WITH_CHECKED_HIERARCHY_NODES" type="spotfire.webPlayer.includedFilterSettings">Include all filter settings. Represent hierarchy paths with checked nodes.</field>
    /// <field name="ALL_WITH_UNCHECKED_HIERARCHY_NODES" type="spotfire.webPlayer.includedFilterSettings">Include all filter settings. Represent hierarchy paths with unchecked nodes.</field>
    
    NONE:'None',
    ALL_WITH_CHECKED_HIERARCHY_NODES:'AllWithCheckedHierarchyNodes',
    ALL_WITH_UNCHECKED_HIERARCHY_NODES:'AllWithUncheckedHierarchyNodes'
};

spotfire.webPlayer.columnDataType =
{
    /// <summary>Defines data column data types.</summary>
    /// <field name="STRING" type="spotfire.webPlayer.columnDataType">Represents a string.</field>
    /// <field name="INTEGER" type="spotfire.webPlayer.columnDataType">Represents an integer.</field>
    /// <field name="REAL" type="spotfire.webPlayer.columnDataType">Represents a real number.</field>
    /// <field name="DATE_TIME" type="spotfire.webPlayer.columnDataType">Represents a date time.</field>
    /// <field name="DATE" type="spotfire.webPlayer.columnDataType">Represents a date.</field>
    /// <field name="TIME" type="spotfire.webPlayer.columnDataType">Represents a time.</field>
    /// <field name="CURRENCY" type="spotfire.webPlayer.columnDataType">Represents a currency.</field>
    /// <field name="BINARY" type="spotfire.webPlayer.columnDataType">Represents binary.</field>
    /// <field name="BOOLEAN" type="spotfire.webPlayer.columnDataType">Represents a boolean.</field>
    /// <field name="LONG_INTEGER" type="spotfire.webPlayer.columnDataType">Represents a long integer.</field>
    /// <field name="TIME_SPAN" type="spotfire.webPlayer.columnDataType">Represents a time span.</field>
    /// <field name="SINGLE_REAL" type="spotfire.webPlayer.columnDataType">Represents a single real.</field>
    
    STRING:'String',
    INTEGER:'Integer',
    REAL:'Real',
    DATE_TIME:'DateTime',
    DATE:'Date',
    TIME:'Time',
    CURRENCY:'Currency',
    BINARY:'Binary',
    BOOLEAN:'Boolean',
    LONG_INTEGER:'LongInteger',
    TIME_SPAN:'TimeSpan',
    SINGLE_REAL:'SingleReal'
};

spotfire.webPlayer.filterType =
{
    /// <summary>Defines filter types.</summary>
    /// <field name="UNDEFINED" type="spotfire.webPlayer.filterType">Represents a undefined filter.</field>
    /// <field name="TEXT_FILTER" type="spotfire.webPlayer.filterType">Represents a text filter.</field>
    /// <field name="CHECK_BOX_FILTER" type="spotfire.webPlayer.filterType">Represents a checkbox filter.</field>
    /// <field name="RANGE_FILTER" type="spotfire.webPlayer.filterType">Represents a range filter.</field>
    /// <field name="LIST_BOX_FILTER" type="spotfire.webPlayer.filterType">Represents a listbox filter.</field>
    /// <field name="RADIO_BUTTON_FILTER" type="spotfire.webPlayer.filterType">Represents a radio button filter.</field>
    /// <field name="ITEM_FILTER" type="spotfire.webPlayer.filterType">Represents a item filter.</field>
    /// <field name="CHECK_BOX_HIERARCHY_FILTER" type="spotfire.webPlayer.filterType">Represents a checkbox hierarchy filter.</field>
    
    UNDEFINED:'Undefined',
    TEXT_FILTER:'TextFilter',
    CHECK_BOX_FILTER:'CheckBoxFilter',
    RANGE_FILTER:'RangeFilter',
    LIST_BOX_FILTER:'ListBoxFilter',
    RADIO_BUTTON_FILTER:'RadioButtonFilter',
    ITEM_FILTER:'ItemFilter',
    CHECK_BOX_HIERARCHY_FILTER:'CheckBoxHierarchyFilter'
};

//
// Classes
//

// ******** Class: Customization ********************************************
spotfire.webPlayer.Customization = function() 
{
    /// <summary>Customize the apperance of the Web Player. All have default value true, except panels that have null.</summary>
    /// <field name="showCustomizableHeader" type="Boolean">Shows/hides the customizable header (including the logo).</field>
    /// <field name="showClose" type="Boolean">Shows/hides the analysis close menu item.</field>
    /// <field name="showToolBar" type="Boolean">Shows/hides the analysis toolbar and menu.</field>
    /// <field name="showExportFile" type="Boolean">Shows/hides the export file menu item.</field>
    /// <field name="showExportVisualization" type="Boolean">Shows/hides the export visualization menu item.</field>
    /// <field name="showUndoRedo" type="Boolean">Shows/hides the undo/redo menu item.</field>
    /// <field name="showDodPanel" type="Boolean" mayBeNull="true">Shows/hides the details on demand panel in the visualization. If null (default value), panel is shown as saved in the analysis.</field>
    /// <field name="showFilterPanel" type="Boolean" mayBeNull="true">Shows/hides the filter panel. If null (default value), panel is shown as saved in the analysis.</field>
    /// <field name="showPageNavigation" type="Boolean">Shows/hides the page navigation controls in the analysis.</field>
    /// <field name="showStatusBar" type="Boolean">Shows/hides statusbar in the Web Player.</field>
    /// <field name="showReloadAnalysis" type="Boolean">Shows/hides the Reload analysis button in the toolbar (for Scheduled Updates).</field>
    /// <field name="showAnalysisInformationTool" type="Boolean">Shows/hides the analysis information tool menu item.</field>
    /// <field name="showHelp" type="Boolean">Shows/hides the help menu item.</field>
    /// <field name="showAbout" type="Boolean">Shows/hides the about menu item.</field>
    /// <field name="showLogout" type="Boolean">Shows/hides the logout menu item.</field>

    this.showCustomizableHeader = true;
    this.showClose = true;
    this.showToolBar = true;
    this.showExportFile = true;
    this.showExportVisualization = true;
    this.showUndoRedo = true;
    this.showDodPanel = null;
    this.showFilterPanel = null;
    this.showPageNavigation = true;
    this.showStatusBar = true;
    this.showReloadAnalysis = true;
    this.showAnalysisInformationTool = true;
    this.showHelp = true;
    this.showAbout = true;
    this.showLogout = true;
};


// ******** Class: Application ************************************************
spotfire.webPlayer.Application = function(webPlayerServerRootUrl, customizationInfo)
{
    /// <summary>The Application class is used to create a Web Player instance. If an analysis is opened, the <c>spotfire.webPlayer.Document</c> object is also acessible from the application.</summary>
    /// <param name="webPlayerServerRootUrl" type="string">The URL to the Web Player server (e.g. 'http://myserver.spotfire.com/SpotfireDxp/' or '../SpotfireDxp/').</param>
    /// <param name="customizationInfo" type="spotfire.webPlayer.Customization">Instance of the <c>spotfire.webPlayer.Customization</c> class.</param>
    /// <field name="analysisDocument" type="spotfire.webPlayer.Document">Reference to the <c>spotfire.webPlayer.Document</c> object. This property will be null if the analysis is not loaded.</field>
    
    this._webPlayerServerRootUrl = webPlayerServerRootUrl;
    this._customizationInfo = customizationInfo;
    this.analysisDocument = null;	
    
    this._setState(spotfire.webPlayer._idleState);
};

spotfire.webPlayer.Application.prototype.open = function(analysisPath, divId, parameters, documentId)
{
    /// <summary>Open a given analysis. The onOpened event will fire when the document is loaded.</summary>
    /// <param name="analysisPath" type="string">The path in the library to the analysis to open.</param>
    /// <param name="divId" type="string">The id of the DIV elemet in which to display the Web Player. The Web Player will adapt to the size of the surrounding DIV.</param>
    /// <param name="parameters" type="string">Load parameters for the analysis (bookmarks, Information Link parameters, etc.). Example: 'Parameters.Param = {val1, "Val 2"}; SetPage(pageIndex = 1); ApplyBookmark(bookmarkName="All");'. For mor information see: Parameter Configuration Block.</param>
    /// <param name="documentId" type="string">If set, just refresh an existing web analysis.</param>
    
    // Handles both ajax communication errors and internal 
    // errors such as if the analysis does not exist.
    var app = this;
    function openFailed(error)
    {        
        app._setState(spotfire.webPlayer._idleState);
        app._onErrorCallback(spotfire.webPlayer.errorCodes.ERROROPEN, error);            
    }
    
    // Cache the arguments to this method.
    this.openArguments =
    {
        "AnalysisPath" : analysisPath,
        "DivId" : divId,
        "Parameters" : parameters
    };
        
    if (!this._isBusy() && !this._isOpened())
    {
        this._setState(spotfire.webPlayer._busyState);
    
        // Remove old Web Player frame if any.
        if (this._webPlayerFrame)
        {
            spotfire.webPlayer.Application._deleteChildNode(this._webPlayerFrame.parentNode,this._webPlayerFrame);
        }

        this._loadProxyAndExecute(
            function ()
            {
                app._openProxy.open(app._webPlayerServerRootUrl, 
                    analysisPath, document.getElementById(divId), 
                    parameters, app._customizationInfo,
                    openFailed,
                    documentId || "");
            });
    }
    else
    {
        this._onErrorCallback(spotfire.webPlayer.errorCodes.ERROROPEN, 
            "Application busy or user not authenticated or document already opened.");
    }
};

spotfire.webPlayer.Application.prototype.close = function()
{
    /// <summary>Closes the currently open document. The <c>spotfire.webPlayer.Application.onError</c> event will be raised if no document is opened, or the closing failed.</summary>
    
    if (this._isOpened() && !this._isBusy())
    {
        this._webPlayerFrame.contentWindow.Ajax.close();
    }
    else
    {
        this._onErrorCallback(spotfire.webPlayer.errorCodes.ERRORCLOSE, 
            "Application busy or no document opened.");
    }
};

spotfire.webPlayer.Application.prototype.onOpened = function(callback) 
{ 
    /// <summary>Event raised when the analysis has finished loading.</summary>
    /// <param name="callback" type="function">The event handler with the following signature: function(analysisDocument) {}.</param>
    
    this._onOpenedCallback = function (result)
    {            
        this._setState(spotfire.webPlayer._idleState);
        callback.call(this, result);   
    }; 
};

spotfire.webPlayer.Application.prototype.onClosed = function(callback) 
{ 
    /// <summary>Event raised when the analysis has closed.</summary>
    /// <param name="callback" type="function">The event handler with the following signature: function(analysisPath) {}.</param>
    
    this._onClosedCallback = function (result)
    {
        this._setState(spotfire.webPlayer._idleState);
        callback.call(this, result);   
    }; 
};

spotfire.webPlayer.Application.prototype.onError = function(callback) 
{ 
    /// <summary>Event raised when an error occurrs in the analysis or API.</summary>
    /// <param name="callback" type="function">The event handler with the following signature: function(errorCode, description) {}.</param>
    
    this._onErrorCallback = callback; 
};


// ******** Class: Document ***************************************************
spotfire.webPlayer.Document = function(application, analysisPath)
{
    /// <summary>[internal constructor] Contains document realated functionality. Created by the application when the analysis is loaded.</summary>
    /// <param name="application" type="spotfire.webPlayer.Application">The Web Player application object which opened the analysis.</param>
    /// <param name="analysisPath" type="string">The library path to the opened analysis.</param>
    /// <field name="marking" type="spotfire.webPlayer.Marking">Reference to the <c>spotfire.webPlayer.Marking</c> object.</field>
    /// <field name="filtering" type="spotfire.webPlayer.Filtering">Reference to the <c>spotfire.webPlayer.Filtering</c> object.</field>
    /// <field name="data" type="spotfire.webPlayer.Data">Reference to the <c>spotfire.webPlayer.Data</c> object.</field>

    this.analysisPath = analysisPath;
    this._application = application;
    
    spotfire.webPlayer.Document._application = application;
    
    this.marking = new spotfire.webPlayer.Marking(application);
    this.filtering = new spotfire.webPlayer.Filtering(application);
    this.data = new spotfire.webPlayer.Data(application);
};

spotfire.webPlayer.Document.prototype.setActivePage = function(pageIndexOrTitle)
{
    /// <summary>Change the active page by page title or page index. The <c>spotfire.webPlayer.Application.onError</c> event will be fired if the page index or page title does not exist.</summary>
    /// <param name="pageIndexOrTitle" type="object">Page index specified by an integer or page title specified by a string to the page to set active.</param>
    
    this._application._webPlayerProxy.analysisDocumentProxy.setActivePage(arguments);
};

spotfire.webPlayer.Document.prototype.applyBookmark = function(bookmarkName)
{
    /// <summary>Applies a bookmark by its name. The <c>spotfire.webPlayer.Application.onError</c> event will be fired if the bookmars does not exist.</summary>
    /// <param name="bookmarkName" type="string">The bookmark name.</param>
    
    this._application._webPlayerProxy.analysisDocumentProxy.applyBookmark(arguments);
};

spotfire.webPlayer.Document.prototype.onActivePageChanged = function(callback)
{
    /// <summary>Event raised when a page change occrurrs in the analysis.</summary>
    /// <param name="callback" type="function">The event handler with the following signature: function(pageState) {}.</param>
    
    this._application._webPlayerProxy.analysisDocumentProxy.onActivePageChanged(arguments);
};

spotfire.webPlayer.Document.prototype.onDocumentReady = function(callback)
{
    /// <summary>Event raised when the document switches to the ready state (the round icon in the status bar becomes green).</summary>
    /// <param name="callback" type="function">The event handler with the following signature: function() {}.</param>
    
    if (typeof(callback) != "undefined" && typeof(callback) == "function")
    {
        this._application._webPlayerFrame.contentWindow.Progress.addOnDocumentUpdatedEventHandler(callback);
    }
    else
    {
        this._application._onErrorCallback(spotfire.webPlayer.errorCodes.ERRORDOCUMENT, 
            "The provided callback is invalid.");
    }
};

spotfire.webPlayer.Document.prototype.applyBookmarkById = function(id)
{
    /// <summary>Applies a bookmark by its id. The <c>spotfire.webPlayer.Application.onError</c> event will be fired if the bookmarks does not exist.</summary>
    /// <param name="id" type="string">The bookmark id.</param>
    
    this._application._webPlayerProxy.analysisDocumentProxy.applyBookmarkById(arguments);
};

spotfire.webPlayer.Document.prototype.getBookmarks = function(callback)
{
    /// <summary>Get the bookmarks in the document.</summary>
    /// <param name="callback" type="function">The event handler with the following signature: function(bookmarksIds) {}. The parameter in the signature is an array of strings.</param>
    
    this._application._webPlayerProxy.analysisDocumentProxy.getBookmarks(arguments);
};

spotfire.webPlayer.Document.prototype.getDocumentMetadata = function(callback)
{
    /// <summary>Get the metadata for the document.</summary>
    /// <param name="callback" type="function">The event handler with the following signature: function(metadata) {}.</param>

    this._application._webPlayerProxy.analysisDocumentProxy.getDocumentMetadata(arguments);
};

spotfire.webPlayer.Document.prototype.getBookmarkNames = function(callback)
{
    /// <summary>Get the names of the bookmarks in the document.</summary>
    /// <param name="callback" type="function">The event handler with the following signature: function(bookmarkNames) {}. The parameter in the signature is an array of strings.</param>
    
    this._application._webPlayerProxy.analysisDocumentProxy.getBookmarkNames(arguments);
};

spotfire.webPlayer.Document.prototype.setDocumentProperty = function(propertyName, propertyValue)
{
    /// <summary>Set the value of a property.</summary>
    /// <param name="propertyName" type="string">The name of the property.</param>
    /// <param name="propertyValue" type="object">The value of the property.</param>
    
    this._application._webPlayerProxy.analysisDocumentProxy.setDocumentProperty(arguments);
};

spotfire.webPlayer.Document.prototype.getDocumentProperty = function(propertyName, callback)
{
    /// <summary>Get the information about the property with given name.</summary>
    /// <param name="propertyName" type="string">The name of the property.</param>
    /// <param name="callback" type="function">A callback function with the following signature: function(property) {}.</param>
    
    this._application._webPlayerProxy.analysisDocumentProxy.getDocumentProperty(arguments);
};

spotfire.webPlayer.Document.prototype.getDocumentProperties = function(callback)
{
    /// <summary>Get a list of all the properties in the document.</summary>
    /// <param name="callback" type="function">A callback function with the following signature: function(properties) {}. The parameter in the signature is an array of Property.</param>
    
    this._application._webPlayerProxy.analysisDocumentProxy.getDocumentProperties(arguments);
};

spotfire.webPlayer.Document.prototype.onDocumentPropertyChanged = function(propertyName, callback)
{
    /// <summary>Event raised when the given property has changed value.</summary>
    /// <param name="propertyName" type="string">The property to listen for changes.</param>
    /// <param name="callback" type="function">The event handler with the following signature: function(property) {}.</param>
    
    this._application._webPlayerProxy.analysisDocumentProxy.onDocumentPropertyChanged(arguments);
};

spotfire.webPlayer.Document.prototype.getActivePage = function(callback)
{
    /// <summary>Gets the active page.</summary>
    /// <param name="callback" type="function">A callback function with the following signature: function(page) {}.</param>
    
     this._application._webPlayerProxy.analysisDocumentProxy.getActivePage(arguments);
};

spotfire.webPlayer.Document.prototype.getPages = function(callback) 
{
    /// <summary>Gets all pages in the opened analysis.</summary>
    /// <param name="callback" type="function">A callback function with the following signature; function(pages) {}. The parameter in the signature is an array of pages.</param>
    
     this._application._webPlayerProxy.analysisDocumentProxy.getPages(arguments);
};

spotfire.webPlayer.Document.prototype._onAnalysisContentStatusChanged = function(callback)
{
     this._application._webPlayerProxy.analysisDocumentProxy.onAnalysisContentStatusChanged(arguments);
};


// ******** Class: Marking ****************************************************
spotfire.webPlayer.Marking = function(application)
{
    /// <summary>[internal constructor] Contains marking related functionality. This object is created when the analysis document is loaded.</summary>
    /// <param name="application" type="spotfire.webPlayer.Application">The Web Player application object which opened the analysis.</param>
    
    this._application = application;
};

spotfire.webPlayer.Marking.prototype.setMarking = function(markingName, dataTableName, whereClause, markingOperation)
{
    /// <summary>Sets a marking in the analysis specified by the input parameters.</summary>
    /// <param name="markingName" type="string">The marking name in which to set the marking.</param>
    /// <param name="tableName" type="string">The data table name in which to set the marking.</param>
    /// <param name="whereClause" type="string">A SQL syntaxed string with conditions for the columns used to set the marking. For more information, see XXX.</param>
    /// <param name="markingOperation" type="spotfire.webPlayer.MarkingOperation">A marking operation to use when setting the marking. The different options are expaned in <c>spotfire.webPlayer.markingOperation</c>.</param>
    
    this._application._webPlayerProxy.analysisDocumentProxy.markingProxy.setMarking(arguments);
};

spotfire.webPlayer.Marking.prototype.onChanged = function(markingName, dataTableName, dataColumnNames, maxRows, callback, intersectionFilteringName)
{
    /// <summary>Event raised when a marking is changed in the analysis, conditioned by the input parameters.</summary>
    /// <param name="markingName" type="string">The marking name in which to listen for changes.</param>
    /// <param name="tableName" type="string">The data table name in which to listen for marking changes.</param>
    /// <param name="columnNames" parameterArray="true" elementType="string">Array of column names in which to listen for marking changes.</param>
    /// <param name="maxRows" type="Number" integer="true">The maximum number of marked rows to return.</param>
    /// <param name="callback" type="function">The event handler with the following signature: function(array) {}. The array has the following format: array["Column Name"][n], where n are the marked rows, numbered from [0, <= maxRows-1].</param>
    /// <param name="intersectionFilteringName" type="string">[optional] Only raise the event if marking changes ocurrs in the intersection between the displayed data from the filtering scheme and the displayed data from the marking parameters.</param>

    this._application._webPlayerProxy.analysisDocumentProxy.markingProxy.onChanged(arguments);
};

spotfire.webPlayer.Marking.prototype.getMarking = function(markingName, dataTableName, dataColumnNames, maxRows, callback)
{
    /// <summary>Gets data from a marking.</summary>
    /// <param name="markingName" type="string">Name of the marking.</param>
    /// <param name="dataTableName" type="string">Name of the data table for the columns.</param>
    /// <param name="dataColumnNames" parameterArray="true" elementType="string">Data columns to get marking data from.</param>
    /// <param name="maxRows" type="int">Maximum number of rows in the result.</param>
    /// <param name="callback" type="function">A callback function with the following signature: function(array) {}. array["Column Name"][n], where n is the data row index.</param>

    this._application._webPlayerProxy.analysisDocumentProxy.markingProxy.getMarking(arguments);
};

spotfire.webPlayer.Marking.prototype.getMarkingNames = function(callback)
{
    /// <summary>Gets all marking names from the opened analysis.</summary>
    /// <param name="callback" type="function">A callback function with the following signature: function(markingNames) {}. The parameter in the signature is an array of strings.</param>

    this._application._webPlayerProxy.analysisDocumentProxy.markingProxy.getMarkingNames(arguments);
};


// ******** Class: Filter *****************************************************
spotfire.webPlayer.Filtering = function(application)
{
    /// <summary>[internal constructor] Contains filtering related functionality. This object is created when the document is loaded.</summary>
    /// <param name="application" type="spotfire.webPlayer.Application">The Web Player application object which opened the analysis.</param>
    
    this._application = application;
};
spotfire.webPlayer.Filtering.prototype.setFilter = function(filterColumn, filteringOperation)
{
    /// <summary>Changes the value(s) of a filter.</summary>
    /// <param name="filterColumn" type="spotfire.webPlayer.FilterColumn">An instance to a FilterColumn object.</param>
    /// <param name="filteringOperation" type="string">THe filtering operation to use.</param>
    
    this._application._webPlayerProxy.analysisDocumentProxy.filteringProxy.setFilter_31(arguments);
    
};
spotfire.webPlayer.Filtering.prototype.resetAllFilters = function() 
{
    /// <summary>Resets all filters to their initial values.</summary>
    
    this._application._webPlayerProxy.analysisDocumentProxy.filteringProxy.resetAllFilters(arguments);
};

spotfire.webPlayer.Filtering.prototype.getFilterColumn = function(filteringSchemeName, dataTableName, columnName, includedFilterSettings, callback)
{
    /// <summary>Gets information about a filter column.</summary>
    /// <param name="filteringSchemeName" type="string">The filtering scheme name.</param>
    /// <param name="dataTableName" type="string">The data table name.</param>
    /// <param name="columnName" type="string">The data column name.</param>
    /// <param name="callback" type="function">A callback function with the following signature: function(filterColumn) {}. The first parameter in the signature is an instance of the spotfire.webPlayer.FilterColumn class.</param>
    
    this._application._webPlayerProxy.analysisDocumentProxy.filteringProxy.getFilterColumn(arguments);
};

spotfire.webPlayer.Filtering.prototype.getActiveFilteringScheme = function(callback)
{
    /// <summary>Gets the active filtering scheme.</summary>
    /// <param name="callback" type="function">A callback function with the following signature: function(filteringScheme) {}. The first parameter in the signature is an instance of the spotfire.webPlayer.Filtering.FilteringScheme class.</param>

     this._application._webPlayerProxy.analysisDocumentProxy.filteringProxy.getActiveFilteringScheme(arguments);
};

spotfire.webPlayer.Filtering.prototype.getFilteringScheme = function(filteringSchemeName, callback)
{
    /// <summary>Gets a specific filtering scheme.</summary>
    /// <param name="filteringSchemeName" type="string">The filtering scheme name.</param>
    /// <param name="callback" type="function">A callback function with the following signature: function(filteringScheme) {}. The first parameter in the signature is an instance of the spotfire.webPlayer.Filtering.FilteringScheme class.</param>

    this._application._webPlayerProxy.analysisDocumentProxy.filteringProxy.getFilteringScheme(arguments);
};

spotfire.webPlayer.Filtering.prototype.getFilteringSchemes = function(callback)
{
    /// <summary>Gets all filtering schemes.</summary>
    /// <param name="callback" type="function">A callback function with the following signature: function(filteringSchemes) {}. The first parameter in the signature is an array of spotfire.webPlayer.Filtering.FilteringScheme instances.</param>

     this._application._webPlayerProxy.analysisDocumentProxy.filteringProxy.getFilteringSchemes(arguments);
};

spotfire.webPlayer.Filtering.prototype.setFilters = function(filterColumns, filteringOperation)
{
    /// <summary>Changes the value(s) of multiple filter columns.</summary>
    /// <param name="filteringSchemeName" type="string">The filtering scheme name.</param>
    /// <param name="filterColumns" parameterArray="true" elementType="spotfire.webPlayer.FilterColumn">An array of FilterColumn objects.</param>
    /// <param name="filteringOperation" type="string">The filtering operation to use.</param>

     this._application._webPlayerProxy.analysisDocumentProxy.filteringProxy.setFilters(arguments);
};

spotfire.webPlayer.Filtering.prototype.getAllModifiedFilterColumns = function(includedFilterSettings, callback)
{
    /// <summary>Gets all modified filter columns in all schemes.</summary>
    /// <param name="includedFilterSettings" type="spotfire.webPlayer.includedFilterSettings">Specify how filter settings should be included in the result.</param>
    /// <param name="callback" type="function">A callback function with the following signature: function(filterColumns) {}. The first parameter in the signature is an array of spotfire.webPlayer.FilterColumn instances.</param>

     this._application._webPlayerProxy.analysisDocumentProxy.filteringProxy.getAllModifiedFilterColumns(arguments);
};

spotfire.webPlayer.Filtering.prototype.getModifiedFilterColumns = function(filteringSchemeName, includedFilterSettings, callback)
{
    /// <summary>Gets all modified filter columns in a scheme.</summary>
    /// <param name="filteringSchemeName" type="string">The filtering scheme name.</param>
    /// <param name="includedFilterSettings" type="spotfire.webPlayer.includedFilterSettings">Specify how filter settings should be included in the result.</param>
    /// <param name="callback" type="function">A callback function with the following signature: function(filterColumns) {}. The first parameter in the signature is an array of spotfire.webPlayer.FilterColumn instances.</param>

     this._application._webPlayerProxy.analysisDocumentProxy.filteringProxy.getModifiedFilterColumns(arguments);
};

spotfire.webPlayer.Filtering.FilteringScheme = function(filteringSchemeName, dataTableNames)
{
    /// <summary>[internal constructor] Creates a filtering scheme object.</summary>
    /// <param name="filteringSchemeName" type="string">The filtering scheme name.</param>
    /// <param name="dataTableNames" parameterArray="true" elementType="spotfire.webPlayer.Data.DataTable">An array of DataTable objects.</param>

    this._application = spotfire.webPlayer.Document._application;
    
    this.filteringSchemeName = filteringSchemeName;
    this.dataTableNames = dataTableNames;
};

spotfire.webPlayer.Filtering.FilteringScheme.prototype.getFilterColumn = function(dataTableName, filterColumnName, includedFilterSettings, callback)
{
    /// <summary>Gets a specific filter column.</summary>
    /// <param name="dataTableName" type="string">The data table name.</param>
    /// <param name="columnName" type="string">The data column name.</param>
    /// <param name="includedFilterSettings" type="spotfire.webPlayer.includedFilterSettings">Specify how filter settings should be included in the result.</param>
    /// <param name="callback" type="function">A callback function with the following signature: function(filterColumn) {}. The first parameter in the signature is an instance of the spotfire.webPlayer.FilterColumn class.</param>

    arguments = [];
    arguments[0] = this.filteringSchemeName;
    arguments[1] = dataTableName;
    arguments[2] = filterColumnName;
    arguments[3] = includedFilterSettings;
    arguments[4] = callback;
    this._application._webPlayerProxy.analysisDocumentProxy.filteringSchemeProxy.getFilterColumn(arguments);
};

spotfire.webPlayer.Filtering.FilteringScheme.prototype.getFilterColumns = function(dataTableName, includedFilterSettings, callback)
{
    /// <summary>Gets all filter columns.</summary>
    /// <param name="dataTableName" type="string">The data table name.</param>
    /// <param name="includedFilterSettings" type="spotfire.webPlayer.includedFilterSettings">Specify how filter settings should be included in the result.</param>
    /// <param name="callback" type="function">A callback function with the following signature: function(filterColumns) {}. The first parameter in the signature is an array of spotfire.webPlayer.FilterColumn instances.</param>

    arguments = [];
    arguments[0] = this.filteringSchemeName;
    arguments[1] = dataTableName;
    arguments[2] = includedFilterSettings;
    arguments[3] = callback;
    this._application._webPlayerProxy.analysisDocumentProxy.filteringSchemeProxy.getFilterColumns(arguments);
};

spotfire.webPlayer.Filtering.FilteringScheme.prototype.getDefaultFilterColumns = function(includedFilterSettings, callback)
{
    /// <summary>Gets all modified filter columns.</summary>
    /// <param name="includedFilterSettings" type="spotfire.webPlayer.includedFilterSettings">Specify how filter settings should be included in the result.</param>
    /// <param name="callback" type="function">A callback function with the following signature: function(filterColumns) {}. The first parameter in the signature is an array of spotfire.webPlayer.FilterColumn instances.</param>

    arguments = [];
    arguments[0] = this.filteringSchemeName;
    arguments[1] = includedFilterSettings;
    arguments[2] = callback;
    this._application._webPlayerProxy.analysisDocumentProxy.filteringSchemeProxy.getDefaultFilterColumns(arguments);
};


// ******** Class: Data *******************************************************
spotfire.webPlayer.Data = function(application)
{
    /// <summary>[internal constructor] Contains data related functionality. This object is created when the document is loaded.</summary>
    /// <param name="application" type="spotfire.webPlayer.Application">The Web Player application object which opened the analysis.</param>
    
    this._application = application;
};

spotfire.webPlayer.Data.prototype.onRangeChanged = function(filteringSchemeName, dataTableName, dataColumnName, callback) 
{
    /// <summary>Event raised when filtered range in a data column is changed. Note that the event will raise when the filtered data changes, and the callback will only specify the range of the filtered column. The event will always return [null, null] as range for Hierarchy Filters.</summary>
    /// <param name="filteringName" type="string">The name of the filtering schema in which to listen for filtering changes.</param>
    /// <param name="tableName" type="string">The data table name in which to listen for filtering changes.</param>
    /// <param name="columnName" type="string">The name of the filtering column in which to listen for filtering changes.</param>
    /// <param name="callback" type="function">The event handler with the following signature: function(filterState) {}.</param>
    
    this._application._webPlayerProxy.analysisDocumentProxy.dataProxy.onRangeChanged(arguments);
};

spotfire.webPlayer.Data.prototype.getDataTable = function(dataTableName, callback)
{
    /// <summary>Gets a specific data table.</summary>
    /// <param name="dataTableName" type="string">The data table name.</param>
    /// <param name="callback" type="function">A callback function with the following signature: function(dataTable) {}. The first parameter in the signature is an instance of the spotfire.webPlayer.Data.DataTable class.</param>

     this._application._webPlayerProxy.analysisDocumentProxy.dataProxy.getDataTable(arguments);
};

spotfire.webPlayer.Data.prototype.getDataTables = function(callback)
{
    /// <summary>Gets all tables.</summary>
    /// <param name="callback" type="function">A callback function with the following signature: function(dataTables) {}. The first parameter in the signature is an array of spotfire.webPlayer.Data.DataTable instances.</param>
    
     this._application._webPlayerProxy.analysisDocumentProxy.dataProxy.getDataTables(arguments);
};

spotfire.webPlayer.Data.prototype.getActiveDataTable = function(callback)
{
    /// <summary>Gets the active data table.</summary>
    /// <param name="callback" type="function">A callback function with the following signature: function(dataTable) {}. The first parameter in the signature is an instance of the spotfire.webPlayer.Data.DataTable class.</param>

     this._application._webPlayerProxy.analysisDocumentProxy.dataProxy.getActiveDataTable(arguments);
};

spotfire.webPlayer.Data.DataTable = function(dataTableName)
{
    /// <summary>[internal constructor] Creates a data table object.</summary>
    /// <param name="dataTableName" type="string">Data table name.</param>

    this._application = spotfire.webPlayer.Document._application;
    this.dataTableName = dataTableName;
};

spotfire.webPlayer.Data.DataTable.prototype.getDataColumn = function(dataColumnName, callback)
{
    /// <summary>Gets a specific data column.</summary>
    /// <param name="dataColumnName" type="string">The data column name.</param>
    /// <param name="callback" type="function">A callback function with the following signature: function(dataColumn) {}. The first parameter in the signature is an instance of the spotfire.webPlayer.Data.DataColumn class.</param>

    arguments = [];
    arguments[0] = this.dataTableName;
    arguments[1] = dataColumnName;
    arguments[2] = callback;
    this._application._webPlayerProxy.analysisDocumentProxy.dataTableProxy.getDataColumn(arguments);
};

spotfire.webPlayer.Data.DataTable.prototype.getDataColumns = function(callback)
{  
    /// <summary>Gets all data columns.</summary>
    /// <param name="callback" type="function">A callback function with the following signature: function(dataColumns) {}. The first parameter in the signature is an array of spotfire.webPlayer.Data.DataColumn instances.</param>

    arguments = [];
    arguments[0] = this.dataTableName;
    arguments[1] = callback;
    this._application._webPlayerProxy.analysisDocumentProxy.dataTableProxy.getDataColumns(arguments);
};

spotfire.webPlayer.Data.DataTable.prototype.searchDataColumns = function(searchExpression, callback)
{
    /// <summary>Searches for data columns given a search expression.</summary>
    /// <param name="searchExpression" type="string">Search expression.</param>
    /// <param name="callback" type="function">A callback function with the following signature: function(dataColumns) {}. The first parameter in the signature is an array of spotfire.webPlayer.Data.DataColumn instances.</param>

    arguments = [];
    arguments[0] = this.dataTableName;
    arguments[1] = searchExpression;
    arguments[2] = callback;
    this._application._webPlayerProxy.analysisDocumentProxy.dataTableProxy.searchDataColumns(arguments);
};

spotfire.webPlayer.Data.DataTable.prototype.getDataTableProperties = function(callback)
{
    /// <summary>Get a list of all the properties to the data table.</summary>
    /// <param name="callback" type="function">A callback function with the following signature: function(properties) {}. The parameter in the signature is an array of spotfire.webPlayer.Property.</param>

    arguments = [];
    arguments[0] = this.dataTableName;
    arguments[1] = callback;
    this._application._webPlayerProxy.analysisDocumentProxy.dataTableProxy.getDataTableProperties(arguments);
};

spotfire.webPlayer.Data.DataTable.prototype.getDataTableProperty = function(propertyName, callback)
{
    /// <summary>Gets information about a specific data table property.</summary>
    /// <param name="propertyName" type="string">Property name.</param>
    /// <param name="callback" type="function">A callback function with the following signature: function(property) {}.</param>

    arguments = [];
    arguments[0] = this.dataTableName;
    arguments[1] = propertyName
    arguments[2] = callback;
    this._application._webPlayerProxy.analysisDocumentProxy.dataTableProxy.getDataTableProperty(arguments);
};

spotfire.webPlayer.Data.DataTable.prototype.setDataTableProperty = function(propertyName, propertyValue)
{
    /// <summary>Sets the value of a property.</summary>
    /// <param name="propertyName" type="string">The name of the property.</param>
    /// <param name="propertyValue" type="object">The value of the property.</param>

    arguments = [];
    arguments[0] = this.dataTableName;
    arguments[1] = propertyName;
    arguments[2] = propertyValue;
    this._application._webPlayerProxy.analysisDocumentProxy.dataTableProxy.setDataTableProperty(arguments);
};

spotfire.webPlayer.Data.DataTable.prototype.onDataTablePropertyChanged = function(propertyName, callback)
{
    /// <summary>Event raised when the given property changes value.</summary>
    /// <param name="propertyName" type="string">The property to listen for changes.</param>
    /// <param name="callback" type="function">The event handler with the following signature: function(property) {}.</param>

    arguments = [];
    arguments[0] = this.dataTableName;
    arguments[1] = propertyName;
    arguments[2] = callback;
    this._application._webPlayerProxy.analysisDocumentProxy.dataTableProxy.onDataTablePropertyChanged(arguments);
};

spotfire.webPlayer.Data.DataColumn = function(dataTableName, dataColumnName, dataType)
{
    /// <summary>[internal constructor] Creates a data column object.</summary>
    /// <param name="dataTableName" type="string">Data table name.</param>
    /// <param name="dataColumnName" type="string">Data column name.</param>
    /// <param name="dataType" type="spotfire.webPlayer.columnDataType">Data type.</param>

    this._application = spotfire.webPlayer.Document._application;
    this.dataTableName = dataTableName;
    this.dataColumnName = dataColumnName;
    this.dataType = dataType;
};

spotfire.webPlayer.Data.DataColumn.prototype.getDataColumnProperties = function(callback)
{
    /// <summary>Get a list of all the properties to the data column.</summary>
    /// <param name="callback" type="function">A callback function with the following signature: function(properties) {}. The parameter in the signature is an array of spotfire.webPlayer.Property.</param>

    arguments = [];
    arguments[0] = this.dataTableName;
    arguments[1] = this.dataColumnName;
    arguments[2] = callback;
    this._application._webPlayerProxy.analysisDocumentProxy.dataColumnProxy.getDataColumnProperties(arguments);
};

spotfire.webPlayer.Data.DataColumn.prototype.getDataColumnProperty = function(propertyName, callback)
{
    /// <summary>Gets information about a specific data column property.</summary>
    /// <param name="propertyName" type="string">Property name.</param>
    /// <param name="callback" type="function">A callback function with the following signature: function(property) {}.</param>

    arguments = [];
    arguments[0] = this.dataTableName;
    arguments[1] = this.dataColumnName;
    arguments[2] = propertyName
    arguments[3] = callback;
    this._application._webPlayerProxy.analysisDocumentProxy.dataColumnProxy.getDataColumnProperty(arguments);
};

spotfire.webPlayer.Data.DataColumn.prototype.setDataColumnProperty = function(propertyName, propertyValue)
{
    /// <summary>Sets the value of a property.</summary>
    /// <param name="propertyName" type="string">The name of the property.</param>
    /// <param name="propertyValue" type="object">The value of the property.</param>

    arguments = [];
    arguments[0] = this.dataTableName;
    arguments[1] = this.dataColumnName;
    arguments[2] = propertyName;
    arguments[3] = propertyValue;
    this._application._webPlayerProxy.analysisDocumentProxy.dataColumnProxy.setDataColumnProperty(arguments);
};

spotfire.webPlayer.Data.DataColumn.prototype.onDataColumnPropertyChanged = function(propertyName, callback)
{
    /// <summary>Event raised when the given property changes value.</summary>
    /// <param name="propertyName" type="string">The property to listen for changes.</param>
    /// <param name="callback" type="function">The event handler with the following signature: function(property) {}.</param>

    arguments = [];
    arguments[0] = this.dataTableName;
    arguments[1] = this.dataColumnName;
    arguments[2] = propertyName;
    arguments[3] = callback;
    this._application._webPlayerProxy.analysisDocumentProxy.dataColumnProxy.onDataColumnPropertyChanged(arguments);
};


//
// State Classes
//

// ******** Class: PageState **************************************************
spotfire.webPlayer.PageState = function(index, pageTitle)
{
    /// <summary>[internal constructor] The state of the active page after a page change has ocurred.</summary>
    /// <param name="index" type="Number" integer="true">The index of the new active page.</param>
    /// <param name="pageTitle" type="string">The title of the new active page.</param>
    
    /// <field name="index" type="Number" integer="true">The index of the new active page.</field>
    /// <field name="pageTitle" type="string">The title fo the new active page.</field>
    
    this.index = index;
    this.pageTitle = pageTitle;
};

// ******** Class: DataColumnRangeState ***************************************
spotfire.webPlayer.DataColumnRangeState = function(filteringName, tableName, columnName, lowValue, highValue)
{
    /// <summary>[internal constructor] The state of the data column after a filtering has ocurred.</summary>
    /// <param name="filteringName" type="string">The name of the filtering schema where the filter is located.</param>
    /// <param name="tableName" type="string">The data table name in which the filter is located.</param>
    /// <param name="columnName" type="string">The name of the filtering column.</param>
    /// <param name="lowValue" type="string">The lowest value in the filtered range.</param>
    /// <param name="highValue" type="string">The highest value in the filtered range.</param>
    
    /// <field name="filteringName" type="string">The name of the filtering schema where the filter is located.</field>
    /// <field name="tableName" type="string">The data table name in which the filter is located.</field>
    /// <field name="columnName" type="string">The name of the filtering column.</field>
    /// <field name="lowValue" type="string">The lowest value in the filtered range.</field>
    /// <field name="highValue" type="string">The highest value in the filtered range.</field>
    
    this.filteringName = filteringSchemeName;
    this.tableName = tableName;
    this.columnName = columnName;
    this.lowValue = lowValue;
    this.highValue = highValue;
};


// ******** Class: FilterSettings *********************************************
spotfire.webPlayer.FilterSettings = function()
{
    /// <summary>Used to configure how a filter should be set.</summary>
    /// <field name="values" parameterArray="true" elementType="object">The values to set in a filter. See the <c>spotfire.webPlayer.Filtering</c> class for how the options are used with the different filters.</field>
    /// <field name="path" parameterArray="true" elementType="string">The path in a CheckBox Hierarchy Filter.</field>
    /// <field name="lowValue" type="string">The low value of the range filter.</field>
    /// <field name="highValue" type="string">The high value of the range filter.</field>
    /// <field name="includeEmpty" type="Boolean">Specifies if empty values should be included in the filtering.</field>
    /// <field name="operation" type="spotfire.webPlayer.filteringOperation">Specifies how the filtering values will be applied.</field>
    /// <field name="searchPattern" type="string">Specifies search pattern for Text Filters and List Box Filter.</field>

    this.values	= [];
    this.lowValue = null;
    this.highValue = null;
    this.includeEmpty = null;
    this.searchPattern = null;
    this.hierarchyPath = null;
};

// ******** Class: WebBookmark **************************************************
spotfire.webPlayer.WebBookmark = function(id, name, author, modified, visibility, webplayerurl, webplayerredirecturl)
{
    /// <param name="id" type="string">The id.</param>
    /// <param name="name" type="string">The name.</param>
    /// <param name="author" type="string">The author.</param>
    /// <param name="modified" type="string">The date when the bookmark was modified.</param>
    /// <param name="visibility" type="string">If set to <c>true</c>, visibility is public.</param>
    /// <param name="webplayerurl" type="string">The web player url.</param>
    /// <param name="webplayerredirecturl" type="string">The web player redirect url.</param>

    /// <field name="id" type="string">The id.</field>
    /// <field name="name" type="string">The name.</field>
    /// <field name="author" type="string">The author.</field>
    /// <field name="modified" type="string">The date when the bookmark was modified.</field>
    /// <field name="visibility" type="string">If set to <c>true</c>, visibility is public.</field>
    /// <field name="webplayerurl" type="string">The web player url.</field>
    /// <field name="webplayerredirecturl" type="string">The web player redirect url.</field>
    
    this.id = id;
    this.name = name;
    this.author = author;
    this.modified = modified;
    this.visibility = visibility;
    this.webplayerurl = webplayerurl;
    this.webplayerredirecturl = webplayerredirecturl;
};

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////



//
// Application Client Side Implementation
//
spotfire.webPlayer.Application.prototype._onOpenedCallback = function() {};
spotfire.webPlayer.Application.prototype._onClosedCallback = function() {};
spotfire.webPlayer.Application.prototype._onErrorCallback = function() {};

spotfire.webPlayer.Application.prototype._loadProxyAndExecute = function (callback)
{
    // Check the path to the web player
    if( !this._webPlayerServerRootUrl || this._webPlayerServerRootUrl.length <= 0 )
    {
        this._onErrorCallback(spotfire.webPlayer.errorCodes.ERROROPEN, 
                    "The web application URL is null or empty.");
        return;
    }
    
    if( this._webPlayerServerRootUrl.charAt(this._webPlayerServerRootUrl.length - 1) != "/" )
    {
        this._onErrorCallback(spotfire.webPlayer.errorCodes.ERROROPEN, 
            "The web application URL '" + this._webPlayerServerRootUrl + "' should end with a '/'.");
        return;
    }

    if (this._openProxyFrame)
    {
        spotfire.webPlayer.Application._deleteChildNode(this._openProxyFrame.parentNode,this._openProxyFrame);
    }

    this._openProxyFrame = document.createElement("iframe"); 
        
    this._openProxyFrame.style.border = "0px";
    this._openProxyFrame.style.width = "0px";
    this._openProxyFrame.style.height = "0px";
    this._openProxyFrame.style.display = "none";
    this._openProxyFrame.style.visibility = "hidden";
    this._openProxyFrame.frameBorder = 0;
    var timeoutTimer = window.setTimeout(function()
    {
        // Show the error in the frame, and report in the error function
        app._openProxyFrame.style.width = "400px";
        app._openProxyFrame.style.height = "300px";     
        app._onErrorCallback(spotfire.webPlayer.errorCodes.ERROROPEN, 
            "Couldn't create the API proxy. Make sure that web application URL '" + this._webPlayerServerRootUrl + "' is correct.");
    }, 120000);
    var app = this;
    this._openProxyFrame.proxyWindowLoaded = function()
    {
        window.clearTimeout(timeoutTimer);
        
        var proxyWindow = app._openProxyFrame.contentWindow;
        
        proxyWindow.proxy.init(
            app,
            app._onDocumentOpened,
            app._onErrorCallback);
        
        app._openProxy = proxyWindow.proxy;
        
        callback();
    };
    
    this._openProxyFrame.src = this._webPlayerServerRootUrl + 
            "OpenProxy.aspx" + 
            document.location.search;
    document.body.appendChild(this._openProxyFrame);
};

spotfire.webPlayer.Application.prototype._onDocumentOpened = function (webPlayerFrame)
{
    this._webPlayerFrame = webPlayerFrame;
    this._webPlayerProxy = webPlayerFrame.contentWindow.webPlayerProxy;
    this.analysisDocument = new spotfire.webPlayer.Document(this, this.openArguments["AnalysisPath"]);
    
    var app = this;
    
    webPlayerFrame.contentWindow.Ajax.onClosed = 
        function (isReload)
        {
            documentId = "";
            if(app._webPlayerFrame !== null && app._webPlayerFrame.parentNode !== null)
            {
                documentId = app._webPlayerFrame.contentWindow.Ajax.DocumentId;
                spotfire.webPlayer.Application._deleteChildNode(app._webPlayerFrame.parentNode,app._webPlayerFrame);
            }
            app._webPlayerFrame = null;
            app._webPlayerProxy = null;
            app.analysisDocument = null;
            
            if(typeof(isReload) !== "undefined" && isReload == true)
            {
                // This is a reload. Open the analysis again with the original
                // arguments. 
                
                app.open(
                    app.openArguments["AnalysisPath"],
                    app.openArguments["DivId"],
                    app.openArguments["Parameters"],
                    documentId);
            }
            else
            {            
                // The analysis has closed.
                app._onClosedCallback();
            }
        };
        
    // Internal error handler
    webPlayerFrame.contentWindow.Ajax.onError = 
        function (message, details)
        {
            // TODO: What to do with the document object?
            app._onErrorCallback(spotfire.webPlayer.errorCodes.ERRORINTERNAL, 
                message + "\n" + details);
        };
        
    // Error handler for abusing the API, discovered on the server
    this._webPlayerProxy.onError =
        function (errorCode, description)
        {
            // TODO: What to do with the document object?
            app._onErrorCallback(errorCode, description);
        };
    
    this._onOpenedCallback(this.analysisDocument);
};

spotfire.webPlayer.Application.isIE = navigator.appName.toLowerCase().indexOf("explorer") != -1;

spotfire.webPlayer.Application._deleteChildNode = function (parent, child) 
{
    if( !child )
    {
        return;
    }
    if (spotfire.webPlayer.Application.isIE && child.outerHTML) 
    {
        // Speed up remove and get around IE bug Q925014 on https connections.
        child.outerHTML = '';
    }
    else 
    {
        parent.removeChild(child);
    }
    child = null;
}

//
// Internal State Management
//
spotfire.webPlayer._idleState = 0;
spotfire.webPlayer._busyState = 1;

spotfire.webPlayer.Application.prototype._setState = function (state)
{
    this._state = state;
};
spotfire.webPlayer.Application.prototype._isBusy = function ()
{
    return (this._state === spotfire.webPlayer._busyState);
};
spotfire.webPlayer.Application.prototype._isOpened = function ()
{
    return (this.analysisDocument !== null);
};

