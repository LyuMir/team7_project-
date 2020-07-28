$(document).ready(function() {
  $(".js-menu-icon").on("click", function() {
    $(this).toggleClass("fa-times fa-bars");
    $(".menu .container").removeClass("container--is-visible");
    $(".menu li").removeClass("is-selected");
    $(".js-navbar").toggleClass("navbar--is-visible");
  });

  $(".menu li").on("click", function(e) {
    e.preventDefault();
    var $this = $(this);
    $this.toggleClass("is-selected");

    var $currentContainer = $(this).find(".container");
    $currentContainer.toggleClass("container--is-visible");

    $(".menu .container")
      .not($currentContainer)
      .removeClass("container--is-visible");
    $(".menu li").not($this).removeClass("is-selected");
  });
});
