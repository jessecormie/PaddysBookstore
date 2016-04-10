<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/script/jquery.js">

<script type="text/javascript">
(function(e){var t,o={className:"autosizejs",append:"",callback:!1,resizeDelay:10},i='<textarea tabindex="-1" style="position:absolute; top:-999px; left:0; right:auto; bottom:auto; border:0; padding: 0; -moz-box-sizing:content-box; -webkit-box-sizing:content-box; box-sizing:content-box; word-wrap:break-word; height:0 !important; min-height:0 !important; overflow:hidden; transition:none; -webkit-transition:none; -moz-transition:none;"/>',n=["fontFamily","fontSize","fontWeight","fontStyle","letterSpacing","textTransform","wordSpacing","textIndent"],s=e(i).data("autosize",!0)[0];s.style.lineHeight="99px","99px"===e(s).css("lineHeight")&&n.push("lineHeight"),s.style.lineHeight="",e.fn.autosize=function(i){return this.length?(i=e.extend({},o,i||{}),s.parentNode!==document.body&&e(document.body).append(s),this.each(function(){function o(){var t,o;"getComputedStyle"in window?(t=window.getComputedStyle(u,null),o=u.getBoundingClientRect().width,e.each(["paddingLeft","paddingRight","borderLeftWidth","borderRightWidth"],function(e,i){o-=parseInt(t[i],10)}),s.style.width=o+"px"):s.style.width=Math.max(p.width(),0)+"px"}function a(){var a={};if(t=u,s.className=i.className,d=parseInt(p.css("maxHeight"),10),e.each(n,function(e,t){a[t]=p.css(t)}),e(s).css(a),o(),window.chrome){var r=u.style.width;u.style.width="0px",u.offsetWidth,u.style.width=r}}function r(){var e,n;t!==u?a():o(),s.value=u.value+i.append,s.style.overflowY=u.style.overflowY,n=parseInt(u.style.height,10),s.scrollTop=0,s.scrollTop=9e4,e=s.scrollTop,d&&e>d?(u.style.overflowY="scroll",e=d):(u.style.overflowY="hidden",c>e&&(e=c)),e+=w,n!==e&&(u.style.height=e+"px",f&&i.callback.call(u,u))}function l(){clearTimeout(h),h=setTimeout(function(){var e=p.width();e!==g&&(g=e,r())},parseInt(i.resizeDelay,10))}var d,c,h,u=this,p=e(u),w=0,f=e.isFunction(i.callback),z={height:u.style.height,overflow:u.style.overflow,overflowY:u.style.overflowY,wordWrap:u.style.wordWrap,resize:u.style.resize},g=p.width();p.data("autosize")||(p.data("autosize",!0),("border-box"===p.css("box-sizing")||"border-box"===p.css("-moz-box-sizing")||"border-box"===p.css("-webkit-box-sizing"))&&(w=p.outerHeight()-p.height()),c=Math.max(parseInt(p.css("minHeight"),10)-w||0,p.height()),p.css({overflow:"hidden",overflowY:"hidden",wordWrap:"break-word",resize:"none"===p.css("resize")||"vertical"===p.css("resize")?"none":"horizontal"}),"onpropertychange"in u?"oninput"in u?p.on("input.autosize keyup.autosize",r):p.on("propertychange.autosize",function(){"value"===event.propertyName&&r()}):p.on("input.autosize",r),i.resizeDelay!==!1&&e(window).on("resize.autosize",l),p.on("autosize.resize",r),p.on("autosize.resizeIncludeStyle",function(){t=null,r()}),p.on("autosize.destroy",function(){t=null,clearTimeout(h),e(window).off("resize",l),p.off("autosize").off(".autosize").css(z).removeData("autosize")}),r())})):this}})(window.jQuery||window.$);

var __slice=[].slice;(function(e,t){var n;n=function(){function t(t,n){var r,i,s,o=this;this.options=e.extend({},this.defaults,n);this.$el=t;s=this.defaults;for(r in s){i=s[r];if(this.$el.data(r)!=null){this.options[r]=this.$el.data(r)}}this.createStars();this.syncRating();this.$el.on("mouseover.starrr","span",function(e){return o.syncRating(o.$el.find("span").index(e.currentTarget)+1)});this.$el.on("mouseout.starrr",function(){return o.syncRating()});this.$el.on("click.starrr","span",function(e){return o.setRating(o.$el.find("span").index(e.currentTarget)+1)});this.$el.on("starrr:change",this.options.change)}t.prototype.defaults={rating:void 0,numStars:5,change:function(e,t){}};t.prototype.createStars=function(){var e,t,n;n=[];for(e=1,t=this.options.numStars;1<=t?e<=t:e>=t;1<=t?e++:e--){n.push(this.$el.append("<span class='glyphicon .glyphicon-star-empty'></span>"))}return n};t.prototype.setRating=function(e){if(this.options.rating===e){e=void 0}this.options.rating=e;this.syncRating();return this.$el.trigger("starrr:change",e)};t.prototype.syncRating=function(e){var t,n,r,i;e||(e=this.options.rating);if(e){for(t=n=0,i=e-1;0<=i?n<=i:n>=i;t=0<=i?++n:--n){this.$el.find("span").eq(t).removeClass("glyphicon-star-empty").addClass("glyphicon-star")}}if(e&&e<5){for(t=r=e;e<=4?r<=4:r>=4;t=e<=4?++r:--r){this.$el.find("span").eq(t).removeClass("glyphicon-star").addClass("glyphicon-star-empty")}}if(!e){return this.$el.find("span").removeClass("glyphicon-star").addClass("glyphicon-star-empty")}};return t}();return e.fn.extend({starrr:function(){var t,r;r=arguments[0],t=2<=arguments.length?__slice.call(arguments,1):[];return this.each(function(){var i;i=e(this).data("star-rating");if(!i){e(this).data("star-rating",i=new n(e(this),r))}if(typeof r==="string"){return i[r].apply(i,t)}})}})})(window.jQuery,window);$(function(){return $(".starrr").starrr()})

$(function(){

  $('#new-review').autosize({append: "\n"});

  var reviewBox = $('#post-review-box');
  var newReview = $('#new-review');
  var openReviewBtn = $('#open-review-box');
  var closeReviewBtn = $('#close-review-box');
  var ratingsField = $('#ratings-hidden');

  openReviewBtn.click(function(e)
  {
    reviewBox.slideDown(400, function()
      {
        $('#new-review').trigger('autosize.resize');
        newReview.focus();
      });
    openReviewBtn.fadeOut(100);
    closeReviewBtn.show();
  });

  closeReviewBtn.click(function(e)
  {
    e.preventDefault();
    reviewBox.slideUp(300, function()
      {
        newReview.focus();
        openReviewBtn.fadeIn(200);
      });
    closeReviewBtn.hide();
    
  });

  $('.starrr').on('starrr:change', function(e, value){
    ratingsField.val(value);
  });
});
</script>

<c:forEach var="book" items="${book}">
	<h2>
		<c:out value="${book.title}"></c:out>
	</h2>
	<img src="<c:out value="${book.image}"></c:out>" height="200"
		width="150">
	<br>
	<b>Author: </b>
	<c:out value="${book.author}"></c:out>
	<br>
	<b>Price: </b>
	<c:out value="${book.price}"></c:out>
	<br>
	<b>Category: </b>
	<c:out value="${book.category}"></c:out>
	
<form accept-charset="UTF-8"
		action="${pageContext.request.contextPath}/addLineItem/${book.title}"
		method="post">
	<div class="center">
		<p></p>
		<div class="input-group">
			<span class="input-group-btn">
				<button type="button" class="btn btn-danger btn-number"
					data-type="minus" data-field="quantity">
					<span class="glyphicon glyphicon-minus"></span>
				</button>
			</span> <input type="text" name="quantity" class="form-control input-number"
				value="1" min="1" max="100"> <span class="input-group-btn">
				<button type="button" class="btn btn-success btn-number"
					data-type="plus" data-field="quantity">
					<span class="glyphicon glyphicon-plus"></span>
				</button>
			</span>
		</div>
		<p></p>
	</div>
	<button class="btn btn-success btn-lg" type="submit">Buy</button>
	</form>
	

	<div class="container">
		<div class="row" style="margin-top: 40px;">
			<div class="col-md-6">
				<div class="well well-sm">
					<div class="text-right">
						<a class="btn btn-success btn-green" href="#reviews-anchor"
							id="open-review-box">Leave a Review</a>
					</div>

					<div class="row" id="post-review-box" style="display: none;">
						<div class="col-md-12">
							<form accept-charset="UTF-8"
								action="${pageContext.request.contextPath}/docreate/${book.title}"
								method="post">
								<input id="ratings-hidden" name="reviewContent" type="hidden">
								<textarea class="form-control animated" cols="50"
									id="reviewContent" name="reviewContent"
									placeholder="Enter your review here..." rows="5"></textarea>

								<div class="text-right">

									<div class="modal-body">
										<span class="rating"> <input type="radio"
											class="rating-input" id="rating-input-1-5" name="rating"
											value="5"> <label for="rating-input-1-5"
											class="rating-star"></label> <input type="radio"
											class="rating-input" id="rating-input-1-4" name="rating"
											value="4"> <label for="rating-input-1-4"
											class="rating-star"></label> <input type="radio"
											class="rating-input" id="rating-input-1-3" name="rating"
											value="3"> <label for="rating-input-1-3"
											class="rating-star"></label> <input type="radio"
											class="rating-input" id="rating-input-1-2" name="rating"
											value="2"> <label for="rating-input-1-2"
											class="rating-star"></label> <input type="radio"
											class="rating-input" id="rating-input-1-1" name="rating"
											value="1"> <label for="rating-input-1-1"
											class="rating-star"></label>
										</span>
									</div>
									<!-- 	<span class="glyphicon glyphicon-remove"></span>Cancel</a> -->
									<button class="btn btn-success btn-lg" type="submit">Save</button>
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</c:forEach>

<c:forEach var="book" items="${book}">
	<c:forEach var="review" items="${book.userReviews}">
		<article class="row">
			<div class="col-md-10 col-sm-10">
				<div class="panel panel-default arrow left">
					<div class="panel-body">
						<header class="text-left">
							<div class="comment-user">
								<i class="fa fa-user"></i> <font size="4"><b> <c:out
											value="${review.user.firstName}"></c:out> <c:out
											value="${review.user.lastName}"></c:out></b></font>
							</div>
							<font size="2"><time class="comment-date"
									datetime="${review.date}">

									<i class="fa fa-clock-o"></i>
									<c:out value="${review.date}"></c:out>
								</time></font>
						</header>
						<div class="comment-post">
							<font size="3">
								<p>
									<c:out value="${review.reviewContent}"></c:out>
								</p> <span class="stars"><span><c:out
											value="${review.rating}"></c:out></span></span>
							</td>
							</font>
						</div>
					</div>
				</div>
			</div>
		</article>
	</c:forEach>
</c:forEach>

<script type="text/javascript">
		$.fn.stars = function() {
			return this.each(function(i, e) {
				$(e).html($('<span/>').width($(e).text() * 16));
			});
		};
		$('.stars').stars();
	</script>

<script type="text/javascript">

$('.btn-number').click(function(e){
  e.preventDefault();
  
  fieldName = $(this).attr('data-field');
  type      = $(this).attr('data-type');
  var input = $("input[name='"+fieldName+"']");
  var currentVal = parseInt(input.val());
  if (!isNaN(currentVal)) {
      if(type == 'minus') {
          
          if(currentVal > input.attr('min')) {
              input.val(currentVal - 1).change();
          } 
          if(parseInt(input.val()) == input.attr('min')) {
              $(this).attr('disabled', true);
          }

      } else if(type == 'plus') {

          if(currentVal < input.attr('max')) {
              input.val(currentVal + 1).change();
          }
          if(parseInt(input.val()) == input.attr('max')) {
              $(this).attr('disabled', true);
          }

      }
  } else {
      input.val(0);
  }
});
$('.input-number').focusin(function(){
 $(this).data('oldValue', $(this).val());
});
$('.input-number').change(function() {
  
  minValue =  parseInt($(this).attr('min'));
  maxValue =  parseInt($(this).attr('max'));
  valueCurrent = parseInt($(this).val());
  
  name = $(this).attr('name');
  if(valueCurrent >= minValue) {
      $(".btn-number[data-type='minus'][data-field='"+name+"']").removeAttr('disabled')
  } else {
      alert('Sorry, the minimum value was reached');
      $(this).val($(this).data('oldValue'));
  }
  if(valueCurrent <= maxValue) {
      $(".btn-number[data-type='plus'][data-field='"+name+"']").removeAttr('disabled')
  } else {
      alert('Sorry, the maximum value was reached');
      $(this).val($(this).data('oldValue'));
  }
  
  
});
$(".input-number").keydown(function (e) {
      // Allow: backspace, delete, tab, escape, enter and .
      if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 190]) !== -1 ||
           // Allow: Ctrl+A
          (e.keyCode == 65 && e.ctrlKey === true) || 
           // Allow: home, end, left, right
          (e.keyCode >= 35 && e.keyCode <= 39)) {
               // let it happen, don't do anything
               return;
      }
      // Ensure that it is a number and stop the keypress
      if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
          e.preventDefault();
      }
  });
</script>