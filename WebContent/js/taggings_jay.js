

	//태깅 시작 
 (function() {

  var $articles = $('.grid article.grid__item');  // Store all 아티클 --images
  var $buttons0 = $('#buttons0');                   // Store buttons element
  var $buttons1 = $('#buttons1');
  var $buttons2 = $('#buttons2');
  var tagged = {};                                // Create tagged object
  var tagged2= {};

  $articles.each(function() {                         // Loop through 아티클이라니까images and
    var article = this;                               // Store img in variable
    //var tags = $(this).data('tags');              // Get this element's tags
    var tags = $(this).find('.content_what').children('span').text()
    var tags2 = $(this).find('.content_where').children('span').text();
                  // Get this element's tags
    //alert(tags);//ㅋㅋ

    if (tags) {                                   // If the element had tags
      tags.split(',').forEach(function(tagName) { // Split at comma and
       if (tagged[tagName] == null || tagged[tagName] == "") {            // If object doesn't have tag
          tagged[tagName] = [];                   // Add empty array to object
        }
	

          tagged[tagName].push(article);       // Add the image to the array
                 
      });
    }

    if (tags2) {                                   // If the element had tags
      tags2.split(',').forEach(function(tagName) { // Split at space <and address
		alret(tagName);
        if (tagged2[tagName] == null || tagged2[tagName] == "") {            // If object doesn't have tag
          tagged2[tagName] = [];                   // Add empty array to object
        }
          tagged2[tagName].push(article);       // Add the image to the array
                 
      });
    }
  });
  $('<button/>', {                                 // Create empty button
    text: '전체보기',                               // Add text 'show all'
    class: 'active',                               // Make it active
    click: function() {                            // Add onclick handler to
      $(this)                                      // Get the clicked on button
        .addClass('active')                        // Add the class of active
        .siblings()                                // Get its siblings
        .removeClass('active');                    // Remove active from siblings
      $articles.hide(500).slideDown(500);                 // Show all images
    }
  }).appendTo($buttons0);                           // Add to buttons

  $.each(tagged, function(tagName) {               // For each tag name
    $('<button/>', {                               // Create empty button
      text: tagName + ' (' + tagged[tagName].length + ')', // Add tag name
      click: function() {                          // Add click handler
        $(this)                                    // The button clicked on
          .addClass('active')                      // Make clicked item active
          .siblings()                              // Get its siblings
          .removeClass('active');                  // Remove active from siblings
        $articles                                      // With all of the images
          .hide(500)                                  // Hide them
          .filter(tagged[tagName])                 // Find ones with this tag
          .fadeIn(300);                                // Show just those images
      }
    }).appendTo($buttons1);                         // Add to the buttons
  });
  $.each(tagged2, function(tagName) {               // For each tag name
    $('<button/>', {  								 // Create empty button
      text: tagName + ' (' + tagged2[tagName].length + ')', // Add tag name
      click: function() {                          // Add click handler
        $(this)                                    // The button clicked on
          .addClass('active')                      // Make clicked item active
          .siblings()                              // Get its siblings
          .removeClass('active');                  // Remove active from siblings
        $articles                                      // With all of the images
          .hide(500)                                  // Hide them
          .filter(tagged2)                 // Find ones with this tag
          .fadeIn(300);                                // Show just those images
      }
    }).appendTo($buttons2);                         // Add to the buttons
  });

}());
