
/**
 *  zdate
 *
 *  zdate is a small, compact and highly configurable date picker plugin for jQuery
 *
 *  Visit {@link http://stefangabos.ro/jquery/zebra-datepicker/} for more information.
 *
 *  For more resources visit {@link http://stefangabos.ro/}
 *
 *  @author     Stefan Gabos <contact@stefangabos.ro>
 *  @version    1.2 (last revision: February 05, 2012)
 *  @copyright  (c) 2011 - 2012 Stefan Gabos
 *  @license    http://www.gnu.org/licenses/lgpl-3.0.txt GNU LESSER GENERAL PUBLIC LICENSE
 *  @package    zdate
 */
;(function($) {

    $.zdate = function(element, options) {

        var defaults = {

            // days of the week; Sunday to Saturday
            days:               ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],

            // direction of the calendar
            // a positive or negative integer: n (a positive integer) creates a future-only calendar beginning at n days
            // after today; -n (a negative integer); if n is 0, the calendar has no restrictions. use boolean true for
            // a future-only calendar starting with today and use boolean false for a past-only calendar ending today.
            //
            // you may also set this property to an array with two elements where the first one is the direction of the
            // calendar as described above while the second one is the number of selectable days in the given direction
            // (the second value is discarded if the first value is "0"!)
            //
            // [1, 7] - a future-only calendar, starting tomorrow, with the next seven days after that being selectable
            // [true, 7] - a future-only calendar, starting today, with the next seven days after that being selectable
            //
            // note that "disabled_dates" property will still apply!
            //
            // default is 0 (no restrictions)
            direction:          0,

            // an array of disabled dates in the following format: 'day month year weekday' where "weekday" is optional
            // and can be 0-6 (Saturday to Sunday); the syntax is similar to cron's syntax: the values are separated by
            // spaces and may contain * (asterisk) - (dash) and , (comma) delimiters:
            // ['1 1 2012'] would disable January 1, 2012;
            // ['* 1 2012'] would disable all days in January 2012;
            // ['1-10 1 2012'] would disable January 1 through 10 in 2012;
            // ['1,10 1 2012'] would disable January 1 and 10 in 2012;
            // ['1-10,20,22,24 1-3 *'] would disable 1 through 10, plus the 22nd and 24th of January through March for every year;
            // ['* * * 0,6'] would disable all Saturdays and Sundays;
            // default is FALSE, no disabled dates
            disabled_dates:     false,

            // week's starting day
            // valid values are 0 to 6, Sunday to Saturday
            // default is 1, Monday
            first_day_of_week:  1,

            // format of the returned date
            // accepts the following characters for date formatting: d, D, j, l, N, w, S, F, m, M, n, Y, y borrowing syntax from (PHP's date function)
            // default is Y-m-d
            format:             'Y-m-d',

            // months names
            months:             ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],

            // the offset, in pixels (x, y), to shift the date picker's position relative to the top-left of the icon
            // that toggles the date picker
            // default is [20, -5]
            offset:             [20, -5],

            // should the icon for opening the datepicker be inside the element?
            // if set to FALSE, the icon will be placed to the right of the parent element, while if set to TRUE it will
            // be placed to the right of the parent element, but *inside* the element itself
            // default is TRUE
            inside:             true,

            // should the element the calendar is attached to, be read-only?
            // if set to TRUE, a date can be set only through the date picker and cannot be entered manually
            // default is TRUE
            readonly_element:   true,

            // should an extra column be shown, showing the number of each week?
            // anything other than FALSE will enable this feature, and use the given value as column title
            // i.e. show_week_number: 'Wk' would enable this feature and have "Wk" as the column's title
            // default is FALSE
            show_week_number:   false,

            // how should the date picker start
            // valid values are "days", "months" and "years"
            // default is "days"
            view:               'years',

            // days of the week that are considered "weekend days"
            // valid values are 0 to 6, Sunday to Saturday
            // default values are 0 and 6 (Saturday and Sunday)
            weekend_days:       [0, 6],
            //  callback function to be executed when a date is selected
            //  the callback function takes 4 arguments:
            //  -   the date in the format specified by the "format" attribute;
            //  -   the date in YYYY-MM-DD format
            //  -   the date as a JavaScript Date object
            //  -   a reference to the element the date picker is attached to, as a jQuery object
            onSelect: null

        }

        // private properties
        var view, datepicker, icon, header, daypicker, monthpicker, yearpicker, current_system_month, current_system_year,
            current_system_day, first_selectable_month, first_selectable_year, first_selectable_day, selected_month,
            selected_year, default_day, default_month, default_year, disabled_dates, shim, direction, last_selectable_date,
            last_selectable_year, last_selectable_month, yearpicker_cells;

        var plugin = this;

        plugin.settings = {}

        // the jQuery version of the element
        // "element" (without the $) will point to the DOM element
        var $element = $(element);

        /**
         *  Constructor method. Initializes the date picker.
         *
         *  @return void
         */
        var init = function() {

            plugin.settings = $.extend({}, defaults, options);

            // if the element should be read-only, set the "readonly" attribute
            //if (plugin.settings.readonly_element) $element.attr('readonly', 'readonly');

            // create the calendar icon
            var html = '<button type="button" class="zdate_Icon">Pick a date</button>';

            // convert to a jQuery object
            icon = $(html);

            // a reference to the icon, as a global property
            plugin.icon = icon;

            // the calendars direction
            direction =

                // future-only
                (
                    !$.isArray(plugin.settings.direction) &&
                    (plugin.settings.direction === true || to_int(plugin.settings.direction) > 0)
                ) || (
                    $.isArray(plugin.settings.direction) && plugin.settings.direction.length == 2 &&
                    (plugin.settings.direction[0] === true || to_int(plugin.settings.direction[0]) > 0)
                ) ? true :

                // past-only
                (
                    !$.isArray(plugin.settings.direction) &&
                    (plugin.settings.direction === false || to_int(plugin.settings.direction) < 0)
                ) || (
                    $.isArray(plugin.settings.direction) && plugin.settings.direction.length == 2 &&
                    (plugin.settings.direction[0] === false || to_int(plugin.settings.direction[0]) < 0)
                ) ? false :

                // no restrictions
                0;

            // by default, we assume that the first selectable date is the current system date
            var date = new Date();

            // extract the date parts
            // also, save the current system year - we'll use them to highlight the current system date
            first_selectable_year = date.getFullYear();
            current_system_year = date.getFullYear();

            // if calendar is future-only or past-only
            if (direction !== 0) {

                // we add/substract that number to first selectable date
                // use the Date object to normalize the date
                // for example, 2011 05 33 will be transformed to 2011 06 02
                date = new Date(
                    first_selectable_year + to_int($.isArray(plugin.settings.direction) ? plugin.settings.direction[0] : plugin.settings.direction)
                );
                // re-extract the date parts
                first_selectable_year = date.getFullYear();
            }

            // if calendar has a direction and a time span
            if (direction !== 0 && $.isArray(plugin.settings.direction) && plugin.settings.direction.length == 2) {

                // we add/substract the number of selectable days
                // use the Date object to normalize the date
                // for example, 2011 05 33 will be transformed to 2011 06 02
                date = new Date(
                    first_selectable_year + ((direction > 0 ? 1 : -1) * to_int(plugin.settings.direction[1]))
                );

                // last selectable year, as an integer in the form of YYYY
                last_selectable_year = to_int(str_concat(date.getFullYear()));
            }

            // by default, only clicking the calendar icon shows the date picker
            // if text box is read-only, clicking it, will also show the date picker

            // attach the click event
            (plugin.settings.readonly_element ? icon.add($element) : icon).bind('click', function(e) {

                e.preventDefault();

                // always show the view defined in settings
                view = plugin.settings.view;

                // if the date picker is visible, hide it
                if (datepicker.css('display') != 'none') plugin.hide();

                // if the date picker is not visible
                else {

                    // get the default date, from the element, and check if it represents a valid date, according to the required format
                    var default_date = check_date($element.val());

                    // if the value represents a valid date
                    if (default_date) {

                        // extract the date parts
                        // we'll use these to highlight the default date in the date picker and as starting point to
                        // what year and month to start the date picker with
                        // why separate values? because selected_* will change as user navigates within the date picker
                        default_year = default_date;
                        selected_year = default_date;

                        // if
                        if (

                            // the default date represents a disabled date
                            is_disabled(str_concat(
                                default_year))

                        ) {

                            // the calendar will start with the first selectable year/month
                            selected_year = first_selectable_year;

                        }

                    // if a default value is not available, or value does not represent a valid date
                    } else {

                        // the calendar will start with the first selectable year/month
                        selected_year = first_selectable_year;

                    }

                    // generate the appropriate view
                    manage_views();

                    // show the date picker
                    plugin.show();

                }

            });

            // inject the icon into the DOM
            icon.insertAfter(element);

            // if icon is to be placed *inside* the element
            if (plugin.settings.inside) {

                // add an extra class to the icon
                icon.addClass('zdate_Icon_Inside');

                // get position and size of the element and of the icon
                var element_position = $element.position(),
                    element_left = element_position.left,
                    element_top = element_position.top,
                    element_width = $element.outerWidth(true),
                    element_height = $element.outerHeight(true),
                    icon_position = icon.position(),
                    icon_left = icon_position.left,
                    icon_top = icon_position.top,
                    icon_width = icon.outerWidth(true),
                    icon_height = icon.outerHeight(true);

                // adjust icon position
              /*   icon.css({
                    'left': -icon_width,
                    'top':  -icon_top + ((element_height - icon_height) / 2)
                });  */
				
				/* icon.css({
				  'right': -1 * $element.outerWidth(true) + icon.outerWidth(true) - 1,
				  'top':  -$element.outerHeight(true) + 4
				});
 */
            }

            // generate the container that will hold everything
            var html = '' +
                '<div class="zdate">' +
                    '<table class="dp_header">' +
                        '<tr>' +
                            '<td class="dp_previous">&laquo;</td>' +
                            '<td class="dp_caption">&nbsp;</td>' +
                            '<td class="dp_next">&raquo;</td>' +
                        '</tr>' +
                    '</table>' +
                    '<table class="dp_daypicker"></table>' +
                    '<table class="dp_monthpicker"></table>' +
                    '<table class="dp_yearpicker"></table>' +
                '</div>';

            // create a jQuery object out of the HTML above and create a reference to it
            datepicker = $(html);

            // a reference to the calendar, as a global property
            plugin.datepicker = datepicker;

            // create references to the different parts of the date picker
            header = datepicker.find('table.dp_header').first();
            daypicker = datepicker.find('table.dp_daypicker').first();
            monthpicker = datepicker.find('table.dp_monthpicker').first();
            yearpicker = datepicker.find('table.dp_yearpicker').first();

            // inject the container into the DOM
            $('body').append(datepicker);

            // add the mouseover/mousevents to all to the date picker's cells
            // except those that are not selectable
            datepicker.
                delegate('td:not(.dp_disabled, .dp_weekend_disabled, .dp_not_in_month, .dp_blocked, .dp_week_number)', 'mouseover', function() {
                    $(this).addClass('dp_hover');
                }).
                delegate('td:not(.dp_disabled, .dp_weekend_disabled, .dp_not_in_month, .dp_blocked, .dp_week_number)', 'mouseout', function() {
                    $(this).removeClass('dp_hover');
                });

            // prevent text highlighting for the text in the header
            // (for the case when user keeps clicking the "next" and "previous" buttons)
            disable_text_select(header.find('td'));

            // event for when clicking the "previous" button
            header.find('.dp_previous').bind('click', function() {

                // if button is not disabled
                if (!$(this).hasClass('dp_blocked')) {

                    // if view is "years"
                    // decrement years by 12
                    if (view == 'years') selected_year -= 12;

                    // if view is "days"
                    // decrement the month and
                    // if month is out of range
                    else if (--selected_month < 0) {

                        // go to the last month of the previous year
                        selected_month = 11;
                        selected_year--;

                    }

                    // generate the appropriate view
                    manage_views();

                }

            });

            // event for when clicking the "next" button
            header.find('.dp_next').bind('click', function() {
                // if button is not disabled
                if (!$(this).hasClass('dp_blocked')) {
                   if (view == 'years') selected_year += 12;
                    // generate the appropriate view
                    manage_views();
                }
            });

            // attach a click event for the cells in the year picker
            yearpicker.delegate('td:not(.dp_disabled)', 'click', function() {

            	// set the selected year
            	selected_year = to_int($(this).html());

            	// put selected date in the element the plugin is attached to, and hide the date picker
            	select_date(selected_year, 1, 1, 'years', $(this));

            	 plugin.hide();
            });

            // bind some events to the document
            $(document).bind({

                //whenever anything is clicked on the page
                'mousedown': plugin._mousedown,
                'keyup': plugin._keyup

            });
        }

        /**
         *  Hides the date picker.
         *
         *  @return void
         */
        plugin.hide = function() {

            // hide the iFrameShim in Internet Explorer 6
            iframeShim('hide');

            // hide the date picker
            datepicker.css('display', 'none');

        }

        /**
         *  Shows the date picker.
         *
         *  @return void
         */
        plugin.show = function() {

            // generate the appropriate view
            manage_views();

            var

                // get the date picker width and height
                datepicker_width = datepicker.outerWidth(),
                datepicker_height = datepicker.outerHeight(),

                // compute the date picker's default left and top
                left = icon.offset().left + plugin.settings.offset[0],
                top = icon.offset().top - datepicker_height + plugin.settings.offset[1],

                // get browser window's width and height
                window_width = $(window).width(),
                window_height = $(window).height(),

                // get browser window's horizontal and vertical scroll offsets
                window_scroll_top = $(window).scrollTop(),
                window_scroll_left = $(window).scrollLeft();

            // if date picker is outside the viewport, adjust its position so that it is visible
            if (left + datepicker_width > window_scroll_left + window_width) left = window_scroll_left + window_width - datepicker_width;
            if (left < window_scroll_left) left = window_scroll_left;
            if (top + datepicker_height > window_scroll_top + window_height) top = window_scroll_top + window_height - datepicker_height;
            if (top < window_scroll_top) top = window_scroll_top;

            // make the date picker visible
            datepicker.css({
                'left':     left,
                'top':      top
            });

            // fade-in the date picker
            // for Internet Explorer < 9 show the date picker instantly or fading alters the font's weight
            datepicker.fadeIn($.browser.msie && $.browser.version.match(/^[6-8]/) ? 0 : 150, 'linear');

            // show the iFrameShim in Internet Explorer 6
            iframeShim();

        }

        /**
         *  Checks if a string represents a valid date according to the format defined by the "format" property.
         *
         *  @param  string  str_date    A string representing a date, formatted accordingly to the "format" property.
         *                              For example, if "format" is "Y-m-d" the string should look like "2011-06-01"
         *
         *  @return boolean             Returns TRUE if string represents a valid date according formatted according to
         *                              the "format" property or FALSE otherwise.
         *
         *  @access private
         */
        var check_date = function(str_date) {

            // if value is given
            if ($.trim(str_date) != '') {

                var

                    // prepare the format by removing white space from it
                    // and also escape characters that could have special meaning in a regular expression
                    format = escape_regexp(plugin.settings.format.replace(/\s/g, '')),

                    // allowed characters in date's format
                    format_chars = ['Y','y'],

                    // "matches" will contain the characters defining the date's format
                    matches = new Array,

                    // "regexp" will contain the regular expression built for each of the characters used in the date's format
                    regexp = new Array;

                // iterate through the allowed characters in date's format
                for (var i = 0; i < format_chars.length; i++)

                    // if character is found in the date's format
                    if ((position = format.indexOf(format_chars[i])) > -1)

                        // save it, alongside the character's position
                        matches.push({character: format_chars[i], position: position});

                // sort characters defining the date's format based on their position, ascending
                matches.sort(function(a, b){ return a.position - b.position; });

                // iterate through the characters defining the date's format
                $.each(matches, function(index, match) {

                    // add to the array of regular expressions, based on the character
                    switch (match.character) {
                        case 'Y': regexp.push('[0-9]{4}'); break;
                        case 'y': regexp.push('[0-9]{2}'); break;
                    }

                });

                // if we have an array of regular expressions
                if (regexp.length) {

                    // we will replace characters in the date's format in reversed order
                    matches.reverse();

                    // iterate through the characters in date's format
                    $.each(matches, function(index, match) {

                        // replace each character with the appropriate regular expression
                        format = format.replace(match.character, '(' + regexp[regexp.length - index - 1] + ')');

                    });

                    // the final regular expression
                    regexp = new RegExp('^' + format + '$', 'ig');

                    // if regular expression was matched
                    if ((segments = regexp.exec(str_date.replace(/\s/g, '')))) {

                        // check if date is a valid date (i.e. there's no February 31)

                        var original_year,
                            // by default, we assume the date is valid
                            valid = true;

                        // reverse back the characters in the date's format
                        matches.reverse();

                        // iterate through the characters in the date's format
                        $.each(matches, function(index, match) {

                            // if the date is not valid, don't look further
                            if (!valid) return true;
                            
                            // based on the character
                            switch (match.character) {
                                case 'Y':
                                    // extract the year from the value entered by the user
                                    original_year = to_int(segments[index + 1]);
                                    break;

                                case 'y':
                                    // extract the year from the value entered by the user
                                    original_year = '19' + to_int(segments[index + 1]);
                                    break;
                            }
                        });

                        // if everything is ok so far
                        if (valid) {
                                return original_year;
                        }
                    }
                }
                // if script gets this far, return false as something must've went wrong
                return false;
            }
        }

        /**
         *  Prevents the possibility of selecting text on a given element. Used on the "previous" and "next" buttons
         *  where text might get accidentally selected when user quickly clicks on the buttons.
         *
         *  Code by http://chris-barr.com/index.php/entry/disable_text_selection_with_jquery/
         *
         *  @param  jQuery Element  el  A jQuery element on which to prevents text selection.
         *
         *  @return void
         *
         *  @access private
         */
        var disable_text_select = function(el) {

            // if browser is Firefox
			if ($.browser.mozilla) el.css('MozUserSelect', 'none');

            // if browser is Internet Explorer
            else if ($.browser.msie) el.bind('selectstart', function() { return false });

            // for the other browsers
			else el.mousedown(function() { return false });

        }

        /**
         *  Escapes special characters in a string, preparing it for use in a regular expression.
         *
         *  @param  string  str     The string in which special characters should be escaped.
         *
         *  @return string          Returns the string with escaped special characters.
         *
         *  @access private
         */
        var escape_regexp = function(str) {

		  return str.replace(/([-.*+?^${}()|[\]\/\\])/g, '\\$1');

        }

        /**
         *  Formats a JavaScript date object to the format specified by the "format" property.
         *  Code taken from http://electricprism.com/aeron/calendar/
         *
         *  @param  date    date    A valid JavaScript date object
         *
         *  @return void
         *
         *  @access private
         */
        var format = function(date) {

            var result = '',

                // extract parts of the date:
                // day number, 1 - 31
                j = date.getDate(),

                // day of the week, 0 - 6, Sunday - Saturday
                w = date.getDay(),

                // the name of the day of the week Sunday - Saturday
                l = plugin.settings.days[w],

                // the month number, 1 - 12
                n = date.getMonth() + 1,

                // the month name, January - December
                f = plugin.settings.months[n - 1],

                // the year (as a string)
                y = date.getFullYear() + '';

            // iterate through the characters in the format
            for (var i = 0; i < plugin.settings.format.length; i++) {

                // extract the current character
                var chr = plugin.settings.format.charAt(i);

                // see what character it is
                switch(chr) {

                    // year as two digits
                    case 'y': y = y.substr(2);

                    // year as four digits
                    case 'Y': result += y; break;

                    // month number, prefixed with 0
                    case 'm': n = str_pad(n, 2);

                    // month number, not prefixed with 0
                    case 'n': result += n; break;

                    // month name, three letters
                    case 'M': f = f.substr(0, 3);

                    // full month name
                    case 'F': result += f; break;

                    // day number, prefixed with 0
                    case 'd': j = str_pad(j, 2);

                    // day number not prefixed with 0
                    case 'j': result += j; break;

                    // day name, three letters
                    case 'D': l = l.substr(0, 3);

                    // full day name
                    case 'l': result += l; break;

                    // ISO-8601 numeric representation of the day of the week, 1 - 7
                    case 'N': w++;

                    // day of the week, 0 - 6
                    case 'w': result += w; break;

                    // English ordinal suffix for the day of the month, 2 characters
                    // (st, nd, rd or th (works well with j))
                    case 'S':

                        if (j % 10 == 1 && j != '11') result += 'st';

                        else if (j % 10 == 2 && j != '12') result += 'nd';

                        else if (j % 10 == 3 && j != '13') result += 'rd';

                        else result += 'th';

                        break;

                    // this is probably the separator
                    default: result += chr;

                }

            }

            // return formated date
            return result;

        }

        /**
         *  Generates the day picker view, and displays it
         *
         *  @return void
         *
         *  @access private
         */
        var generate_daypicker = function() {

            var

                // get the number of days in the selected month
                days_in_month = new Date(selected_year, selected_month + 1, 0).getDate(),

                // get the selected month's starting day (from 0 to 6)
                first_day = new Date(selected_year, selected_month, 1).getDay(),

                // how many days are there in the previous month
                days_in_previous_month = new Date(selected_year, selected_month, 0).getDate(),

                // how many days are there to be shown from the previous month
                days_from_previous_month = first_day - plugin.settings.first_day_of_week;

            // the final value of how many days are there to be shown from the previous month
            days_from_previous_month = days_from_previous_month < 0 ? 7 + days_from_previous_month : days_from_previous_month;

            // manage header caption and enable/disable navigation buttons if necessary
            manage_header(plugin.settings.months[selected_month] + ', ' + selected_year);

            // start generating the HTML
            var html = '<tr>';

            // if a column featuring the number of the week is to be shown
            if (plugin.settings.show_week_number)

                // column title
                html += '<th>' + plugin.settings.show_week_number + '</th>';

            // name of week days
            // show only the first two letters
            // and also, take in account the value of the "first_day_of_week" property
            for (var i = 0; i < 7; i++)

                html += '<th>' + plugin.settings.days[(plugin.settings.first_day_of_week + i) % 7].substr(0, 2) + '</th>';

            html += '</tr><tr>';

            // the calendar shows a total of 42 days
            for (var i = 0; i < 42; i++) {

                // seven days per row
                if (i > 0 && i % 7 == 0) html += '</tr><tr>';

                // if week number is to be shown
                if (i % 7 == 0 && plugin.settings.show_week_number) {

                    var

                        // first day of the year
                        first_day_of_year = new Date(selected_year, 0, 1),

                        // current date
                        current_date = new Date(selected_year, selected_month, i),

                        // compute the current week's number
                        week_number = Math.ceil((((current_date - first_day_of_year) / 86400000) + current_date.getDay() + 1) / 7);

                    // add week number
                    html += '<td class="dp_week_number">' + week_number + '</td>';

                }

                // the number of the day in month
                var day = (i - days_from_previous_month + 1);

                // if this is a day from the previous month
                if (i < days_from_previous_month)

                    html += '<td class="dp_not_in_month">' + (days_in_previous_month - days_from_previous_month + i + 1) + '</td>';

                // if this is a day from the next month
                else if (day > days_in_month)

                    html += '<td class="dp_not_in_month">' + (day - days_in_month) + '</td>';

                // if this is a day from the current month
                else {

                    var

                        // get the week day (0 to 6, Sunday to Saturday)
                        weekday = (plugin.settings.first_day_of_week + i) % 7,

                        // current date, as an integer in the form of YYYYMMDD
                        now = to_int(str_concat(selected_year, str_pad(selected_month, 2), str_pad(day, 2))),

                        class_name = '';

                    // if date needs to be disabled
                    if (is_disabled(now))

                        // if day is in weekend
                        if ($.inArray(weekday, plugin.settings.weekend_days) > -1) class_name = 'dp_weekend_disabled';

                        // if work day
                        else class_name += ' dp_disabled';

                    // if there are no direction restrictions
                    else {

                        // if day is in weekend
                        if ($.inArray(weekday, plugin.settings.weekend_days) > -1) class_name = 'dp_weekend';

                        // highlight the currently selected date
                        if (selected_month == default_month && selected_year == default_year && default_day == day) class_name += ' dp_selected';

                        // highlight the current system date
                        else if (selected_month == current_system_month && selected_year == current_system_year && current_system_day == day) class_name += ' dp_current';

                    }

                    // print the day of the month
                    html += '<td' + (class_name != '' ? ' class="' + $.trim(class_name) + '"' : '') + '>' + str_pad(day, 2) + '</td>';

                }

            }

            // wrap up generating the day picker
            html += '</tr>';

            // inject the day picker into the DOM
            daypicker.html($(html));

            // cache all the cells
            // (we need them so that we can easily remove the "dp_selected" class from all of them when user selects a date)
            daypicker_cells = $('td:not(.dp_disabled, .dp_weekend_disabled, .dp_not_in_month, .dp_blocked, .dp_week_number)', daypicker);
            
            // make the day picker visible
            daypicker.css('display', '');
            
        }
        
        /**
         *  Generates the year picker view, and displays it
         *
         *  @return void
         *
         *  @access private
         */
        var generate_yearpicker = function() {

            // manage header caption and enable/disable navigation buttons if necessary
            manage_header(selected_year - 7 + ' - ' + (selected_year + 4));

            // start generating the HTML
            var html = '<tr>';

            // we're showing 9 years at a time, current year in the middle
            for (var i = 0; i < 12; i++) {

                // three years per row
                if (i > 0 && i % 3 == 0) html += '</tr><tr>';

                var class_name = '',

                    // current year as an integer
                    now = to_int(selected_year - 7 + i);

                // if year needs to be disabled
                if (is_disabled(now)) class_name += ' dp_disabled';

                // else, if a date is already selected and this is that particular year, highlight it
                else if (default_year && default_year == selected_year - 7 + i) class_name += ' dp_selected'

                // else, if this is the current system year, highlight it
                else if (current_system_year == (selected_year - 7 + i)) class_name += ' dp_current';

                // first three letters of the month's name
                html += '<td' + ($.trim(class_name) != '' ? ' class="' + $.trim(class_name) + '"' : '') + '>' + (selected_year - 7 + i) + '</td>';

            }

            // wrap up
            html += '</tr>';

            // inject into the DOM
            yearpicker.html($(html));
            
            // cache all the cells
            // (we need them so that we can easily remove the "dp_selected" class from all of them when user selects a year)
            yearpicker_cells = $('td:not(.dp_disabled)', yearpicker);

            // make the year picker visible
            //yearpicker.css('display', '');
            yearpicker.animate({opacity: 'show',height: 'show'},300);

        }

        /**
         *  Generates an iFrame shim in Internet Explorer 6 so that the date picker appears above select boxes.
         *
         *  @return void
         *
         *  @access private
         */
        var iframeShim = function(action) {

            // this is necessary only if browser is Internet Explorer 6
    		if ($.browser.msie && $.browser.version.match(/^6/)) {

                // if the iFrame was not yet created
                // "undefined" evaluates as FALSE
                if (!shim) {

                    // the iFrame has to have the element's zIndex minus 1
                    var zIndex = to_int(datepicker.css('zIndex')) - 1;

                    // create the iFrame
                    shim = jQuery('<iframe>', {
                        'src':                  'javascript:document.write("")',
                        'scrolling':            'no',
                        'frameborder':          0,
                        'allowtransparency':    'true',
                        css: {
                            'zIndex':       zIndex,
                            'position':     'absolute',
                            'top':          -1000,
                            'left':         -1000,
                            'width':        datepicker.outerWidth(),
                            'height':       datepicker.outerHeight(),
                            'filter':       'progid:DXImageTransform.Microsoft.Alpha(opacity=0)',
                            'display':      'none'
                        }
                    });

                    // inject iFrame into DOM
                    $('body').append(shim);

                }

                // what do we need to do
                switch (action) {

                    // hide the iFrame?
                    case 'hide':

                        // set the iFrame's display property to "none"
                        shim.css('display', 'none');

                        break;

                    // show the iFrame?
                    default:

                        // get date picker top and left position
                        var offset = datepicker.offset();

                        // position the iFrame shim right underneath the date picker
                        // and set its display to "block"
                        shim.css({
                            'top':      offset.top,
                            'left':     offset.left,
                            'display':  'block'
                        });

                }

            }

        }

        /**
         *  Checks if, according to the direction of the calendar and/or the values defined by the "disabled_dates"
         *  property, a day, a month or a year needs to be disabled.
         *
         *  @param  integer now     An integer representing the value that needs to be checked.
         *
         *                          A value in the form of YYYYMMDD will validate a date;
         *                          A value in the form of YYYYMM will validate a month;
         *                          A value in the form of YYYY will validate a year;
         *
         *  @return boolean         Returns TRUE if the given value is valid or FALSE otherwise
         *
         *  @access private
         */
        var is_disabled = function(now) {

            // if there is a direction restriction
            if (direction !== 0) {

                // get the length of the argument
                var len = (now + '').length;

                // if we're checking days
                if (len == 8 && (

                    // calendar is future-only
                    (direction &&

                        // but day is before the first selectable date
                        ((now < str_concat(first_selectable_year, str_pad(first_selectable_month, 2), str_pad(first_selectable_day, 2))) ||

                        // or, if we have a time span defined and the day is outside that time span
                        (typeof last_selectable_date != 'undefined' && now > last_selectable_date))

                    ) ||

                    // calendar is past-only
                    (!direction &&

                        // but day is after the first selectable month
                        ((now > str_concat(first_selectable_year, str_pad(first_selectable_month, 2), str_pad(first_selectable_day, 2))) ||

                        // or, if we have a time span defined and the day is outside that time span
                        (typeof last_selectable_date != 'undefined' && now < last_selectable_date))

                    )

                    // day needs to be disabled
                    )) return true;

                // if we're checking months
                else if (len == 6 && (

                    // calendar is future-only
                    (direction &&

                        // but month is before the first selectable month
                        ((now < str_concat(first_selectable_year, str_pad(first_selectable_month, 2))) ||

                        // or, if we have a time span defined and the month is outside that time span
                        (typeof last_selectable_date != 'undefined' && now > last_selectable_month))


                    ) ||

                    // calendar is past-only
                    (!direction &&

                        // but month is after the first selectable month
                        ((now > str_concat(first_selectable_year, str_pad(first_selectable_month, 2))) ||

                        // or, if we have a time span defined and the month is outside that time span
                        (typeof last_selectable_date != 'undefined' && now < last_selectable_month))

                    )

                    // month needs to be disabled
                    )) return true;

                // if we're checking years
                else if (len == 4 && (

                    // calendar is future-only
                    (direction &&

                        // but year is before the first selectable year
                        ((now < first_selectable_year) ||

                        // or, if we have a time span defined and the year is outside that time span
                        (typeof last_selectable_date != 'undefined' && now > last_selectable_year))

                    ) ||

                    // calendar is past-only
                    (!direction &&

                        // but year is after the first selectable year
                        ((now > first_selectable_year) ||

                        // or, if we have a time span defined and the year is outside that time span
                        (typeof last_selectable_date != 'undefined' && now < last_selectable_year))

                    )

                    // year needs to be disabled
                    )) return true;

            }

            // if there are rules for disabling dates
            if (disabled_dates) {

                // convert the argument to a string
                now = now + '';

                // extract the year and the month from "now"
                var year = to_int(now.substr(0, 4)),
                    month = to_int(now.substr(4, 2)) + 1,
                    day = to_int(now.substr(6, 2)),

                    // by default, we assume the day/month/year is not to be disabled
                    disabled = false;

                // iterate through the rules for disabling dates
                $.each(disabled_dates, function() {

                    // if the date is to be disabled, don't look any further
                    if (disabled) return;

                    var rule = this;

                    // if the rules apply for the current year
                    if ($.inArray(year, rule[2]) > -1 || $.inArray('*', rule[2]) > -1)

                        // if the rules apply for the current month
                        if ((undefined != month && $.inArray(month, rule[1]) > -1) || $.inArray('*', rule[1]) > -1)

                            // if the rules apply for the current day
                            if ((undefined != day && $.inArray(day, rule[0]) > -1) || $.inArray('*', rule[0]) > -1) {

                                // if day is to be disabled whatever the day
                                // don't look any further
                                if (rule[3] == '*') return (disabled = true);

                                // get the weekday
                                var weekday = new Date(year, month - 1, day).getDay();

                                // if weekday is to be disabled
                                // don't look any further
                                if ($.inArray(weekday, rule[3]) > -1) return (disabled = true);

                            }

                });

                // if the day/month/year needs to be disabled
                if (disabled) return true;

            }

            // if script gets this far it means that the day/month/year doesn't need to be disabled
            return false;

        }

        /**
         *  Sets the caption in the header of the date picker and enables or disables navigation buttons when necessary.
         *
         *  @param  string  caption     String that needs to be displayed in the header
         *
         *  @return void
         *
         *  @access private
         */
        var manage_header = function(caption) {

            // update the caption in the header
            header.find('.dp_caption').html(caption);

            // if calendar is future-only or past-only
            if (direction !== 0) {

                // get the current year and month
                var year = selected_year,
                    month = selected_month,
                    next, previous;

              if (view == 'years') {

                    // clicking on "previous" should show a list with some previous years
                    // (will check later if that particular list of years contains selectable years)
                    previous = year - 7;

                    // clicking on "next" should show a list with some following years
                    // (will check later if that particular list of years contains selectable years)
                    next = year + 7;

                }

                // if the previous month/year is not selectable or, in case of years, if the list doesn't contain selectable years
                if (is_disabled(previous)) {

                    // disable the "previous" button
                    header.find('.dp_previous').addClass('dp_blocked');
                    header.find('.dp_previous').removeClass('dp_hover');

                // otherwise enable the "previous" button
                } else header.find('.dp_previous').removeClass('dp_blocked');

                // if the next month/year is not selectable or, in case of years, if the list doesn't contain selectable years
                if (is_disabled(next)) {

                    // disable the "next" button
                    header.find('.dp_next').addClass('dp_blocked');
                    header.find('.dp_next').removeClass('dp_hover');

                // otherwise enable the "next" button
                } else header.find('.dp_next').removeClass('dp_blocked');

            }

        }

        /**
         *  Shows the appropriate view (days, months or years) according to the current value of the "view" property.
         *
         *  @return void
         *
         *  @access private
         */
		var manage_views = function() {
            // if the day picker was not yet generated
            if (daypicker.text() == '' || view == 'years') {

                // if the day picker was not yet generated
                if (daypicker.text() == '') {

                    // temporarily make the date picker visible
                    // so that we can later grab its width and height
                    datepicker.css({
                        'left':     -1000,
                        'display':  'block'
                    });

    				// generate the day picker
    				generate_daypicker();

                    // get the day picker's width and height
                    var width = daypicker.outerWidth(),
                        height = daypicker.outerHeight();

                    // adjust the size of the header
                    header.css('width', width);
                   
                    // make the year picker have the same size as the day picker
                    yearpicker.css({
                        'width':    width,
                        'height':   height
                    });

                    // hide the date picker again
                    datepicker.css({
                        'display':  'none'
                    });

                // if the day picker was previously generated at least once
				// generate the day picker
                } else // generate the year picker
                generate_yearpicker();

                // hide the day and the month pickers
                daypicker.css('display', 'none');
                monthpicker.css('display', 'none');
            } 
		}

        /**
         *  Left-pad a string to a certain length with zeroes.
         *
         *  @param  string  str     The string to be padded.
         *
         *  @param  integer len     The length to which the string must be padded
         *
         *  @return string          Returns the string left-padded with leading zeroes
         *
         *  @access private
         */
        var str_pad = function(str, len) {

            // make sure argument is a string
            str += '';

            // pad with leading zeroes until we get to the desired length
            while (str.length < len) str = '0' + str;

            // return padded string
            return str;

        }

        /**
         *  Puts the specified date in the element the plugin is attached to, and hides the date picker.
         *
         *  @param  integer     year    The year
         *
         *  @param  integer     month   The month
         *
         *  @param  integer     day     The day
         *
         *  @param  string      view    The view from where the method was called
         *
         *  @param  object      cell    The element that was clicked
         *
         *  @return void
         *
         *  @access private
         */
        var select_date = function(year, month, day, view, cell) {

        	var

        	// construct a new date object from the arguments
        	default_date = new Date(year, month, day, 12, 0, 0),

        	// pointer to the cells in the current view
        	view_cells = (yearpicker_cells),

        	// the selected date, formatted correctly
        	selected_value = format(default_date);

        	// set the currently selected and formated date as the value of the element the plugin is attached to
        	$element.val(selected_value);

        	// extract the date parts and reassign values to these variables
        	// so that everything will be correctly highlighted
        	default_month = default_date.getMonth();
        	selected_month = default_date.getMonth();
        	default_year = default_date.getFullYear();
        	selected_year = default_date.getFullYear();
        	default_day = default_date.getDate();

        	// remove the "selected" class from all cells in the current view
        	view_cells.removeClass('dp_selected');

        	// add the "selected" class to the currently selected cell
        	cell.addClass('dp_selected');

        	// hide the date picker
        	//plugin.hide();      
        	// if a callback function exists for when selecting a date
        	if (plugin.settings.onSelect && typeof plugin.settings.onSelect == 'function')

        		// execute the callback function
        		plugin.settings.onSelect(selected_value, year + '-' + str_pad(month + 1, 2) + '-' + str_pad(day, 2), default_date, $element);

        	// move focus to the element the plugin is attached to
        	$element.focus();

        }
        
        /**
         *  Concatenates any number of arguments and returns them as string.
         *
         *  @return string  Returns the concatenated values.
         *
         *  @access private
         */
        var str_concat = function() {

            var str = '';

            // concatenate as string
            for (var i = 0; i < arguments.length; i++) str += (arguments[i] + '');

            // return the concatenated values
            return str;

        }

        /**
         *  Returns the integer representation of a string
         *
         *  @return int     Returns the integer representation of the string given as argument
         *
         *  @access private
         */
        var to_int = function(str) {

            // as the "direction" property can be true or false, make sure we interpret them as "0"
            return parseInt((str === true || str === false ? 0 : str) , 10);

        }

        /**
         *  Function to be called when the "onKeyUp" event occurs
         *
         *  Why as a separate function and not inline when binding the event? Because only this way we can "unbind" it
         *  if the date picker is destroyed
         *
         *  @return boolean     Returns TRUE
         *
         *  @access private
         */
        plugin._keyup = function(e) {

            // if the date picker is visible
            // and the pressed key is ESC
            // hide the date picker
            if (datepicker.css('display') == 'block' || e.which == 27) plugin.hide();

            return true;

        }

        /**
         *  Function to be called when the "onMouseDown" event occurs
         *
         *  Why as a separate function and not inline when binding the event? Because only this way we can "unbind" it
         *  if the date picker is destroyed
         *
         *  @return boolean     Returns TRUE
         *
         *  @access private
         */
        plugin._mousedown = function(e) {

            // if the date picker is visible
            if (datepicker.css('display') == 'block') {

                // if we clicked the date picker's icon, let the onClick event of the icon to handle the event
                // (we want it to toggle the date picker)
                if ($(e.target).get(0) === icon.get(0)) return true;

                // if what's clicked is not inside the date picker
                // hide the date picker
                if ($(e.target).parents().filter('.zdate').length == 0) plugin.hide();

            }

            return true;

        }

        // initialize the plugin
        init();

    }

    $.fn.zdate = function(options) {

        return this.each(function() {

            // if element has a date picker already attached
            if (undefined != $(this).data('zdate')) {

                // get reference to the previously attached date picker
                var plugin = $(this).data('zdate');

                // remove the attached icon and calendar
                plugin.icon.remove();
                plugin.datepicker.remove();

                // remove associated event handlers from the document
                $(document).unbind('keyup', plugin._keyup);
                $(document).unbind('mousedown', plugin._mousedown);

            }

            // create a new instance of the plugin
            var plugin = new $.zdate(this, options);

            // save a reference to the newly created object
            $(this).data('zdate', plugin);

        });

    }

})(jQuery);