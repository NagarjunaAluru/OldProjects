	$('.date').each(function() {
		// This checking is requrired to avoid multiple registrations; zdate-plugin checking of 'data' is not working.
		if(!$(this).attr('zdateRegistered')) {
			$(this).zdate({
				format: 'd M Y',
				offset:  [20, 25],
				first_day_of_week: '0'
			});
			$(this).attr('zdateRegistered', 'true');
			
			$(this).on('blur', function() {
				formatDate(this, 'd M Y');
			});
		}
	});	
  	function formatDate(element, format) {
  		var strDate = $(element).val();
  		
  		if(strDate == null || strDate == '') {
  			return;
  		}
  		
  		var date = new Date(strDate);
  		if(!date.isValid()) {
  			$(element).val('');
  			return;
  		}
  		
  		var settings = {
  				days: ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'],
  				months: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December']
  		};
  		
  		var str_pad = function(str, len) {

  	        // make sure argument is a string
  	        str += '';

  	        // pad with leading zeroes until we get to the desired length
  	        while (str.length < len) str = '0' + str;

  	        // return padded string
  	        return str;

  	    };
  		
  	    var result = '',

  	    // extract parts of the date:
  	    // day number, 1 - 31
  	    j = date.getDate(),

  	    // day of the week, 0 - 6, Sunday - Saturday
  	    w = date.getDay(),

  	    // the name of the day of the week Sunday - Saturday
  	    l = settings.days[w],

  	    // the month number, 1 - 12
  	    n = date.getMonth() + 1,

  	    // the month name, January - December
  	    f = settings.months[n - 1],

  	    // the year (as a string)
  	    y = date.getFullYear() + '';
  	    
  	    // iterate through the characters in the format
  	    for (var i = 0; i < format.length; i++) {

  	        // extract the current character
  	        var chr = format.charAt(i);
  	        
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
  	    $(element).val(result);
  	}