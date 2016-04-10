<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/bootstrap-3.3.6-dist/css/script/jquery.js">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"
	rel="stylesheet">
	
<body style="font-family: 'Open Sans', sans-serif;">
	<div class="container">
		<div class="centered title">
			<h1>Welcome to our checkout.</h1>
		</div>
	</div>
	<form accept-charset="UTF-8"
		action="${pageContext.request.contextPath}/proceed"
		class="require-validation" data-cc-on-file="false"
		data-stripe-publishable-key="pk_bQQaTxnaZlzv4FnnuZ28LFHccVSaj"
		id="payment-form" method="post">
		
		<hr class="featurette-divider"></hr>
		<div class="col-sm-6">
			<div class="tab-content">
				<script src='https://js.stripe.com/v2/' type='text/javascript'></script>

				<h2>Payment Information</h2>
				<div class='form-row'>
					<label class='control-label'>Name on Card</label> <input
						class='form-control' id="nameOnCard" type='text' name="nameOnCard">
				</div>
				
				<div class='form-row'>
					<div class='form-group card required'>
						<label class='control-label'>Card Number</label> <input
							autocomplete='off' class='form-control card-number' type='text'
							name="cardNumber" id="cardNumber">
					</div>
				</div>
				<div class='form-row'>
					<div class='form-group cvc required'>
						<label class='control-label'>CVC</label> <input name="cvc" id="cvc"
							autocomplete='off' class='form-control card-cvc'
							placeholder='ex. 311' type='text'>
					</div>
					<div class='form-group expiration required'>
						<label class='control-label'>Expiration</label> <input
							class='form-control card-expiry-month' placeholder='MM'
							type='text' name="month" id="month">
					</div>
					<div class='form-group expiration required'>
						<label class='control-label'>Year</label> <input
							class='form-control card-expiry-year' placeholder='YYYY'
							type='text' name="year" id="year">
					</div>
				</div>
			</div>
		</div>

		<div class="col-sm-6">
			<label class='control-label'></label>
			<!-- spacing -->

			<h2>Billing Address</h2>
			<br>
			<div class="control-group">
				<label for="address" class="control-label"> Street Address </label>
				<div class="controls">
					<input name="address" placeholder="W 123 Street" type="text"
						id="address"><span class="help-inline"></span>
				</div>
			</div>

			<div class="control-group">
				<label for="zip" class="control-label"> Zip Code </label>
				<div class="controls">
					<input name="zip" type="text" value="" id="zip">
				</div>
			</div>

			<div class="control-group">
				<label for="city" class="control-label"> City </label>
				<div class="controls">
					<input name="city" type="text" value="" id="city">
				</div>
			</div>

			<div class="control-group">
				<label for="country" class="control-label"> Country </label>
				<div class="controls">
					<select name="country" id="country">
						<option value=""></option>
						<option value="AR">Argentina</option>
						<option value="AU">Australia</option>
						<option value="AT">Austria</option>
						<option value="BY">Belarus</option>
						<option value="BE">Belgium</option>
						<option value="BA">Bosnia and Herzegovina</option>
						<option value="BR">Brazil</option>
						<option value="BG">Bulgaria</option>
						<option value="CA">Canada</option>
						<option value="CL">Chile</option>
						<option value="CN">China</option>
						<option value="CO">Colombia</option>
						<option value="CR">Costa Rica</option>
						<option value="HR">Croatia</option>
						<option value="CU">Cuba</option>
						<option value="CY">Cyprus</option>
						<option value="CZ">Czech Republic</option>
						<option value="DK">Denmark</option>
						<option value="DO">Dominican Republic</option>
						<option value="EG">Egypt</option>
						<option value="EE">Estonia</option>
						<option value="FI">Finland</option>
						<option value="FR">France</option>
						<option value="GE">Georgia</option>
						<option value="DE">Germany</option>
						<option value="GI">Gibraltar</option>
						<option value="GR">Greece</option>
						<option value="HK">Hong Kong S.A.R., China</option>
						<option value="HU">Hungary</option>
						<option value="IS">Iceland</option>
						<option value="IN">India</option>
						<option value="ID">Indonesia</option>
						<option value="IR">Iran</option>
						<option value="IQ">Iraq</option>
						<option value="IE">Ireland</option>
						<option value="IL">Israel</option>
						<option value="IT">Italy</option>
						<option value="JM">Jamaica</option>
						<option value="JP">Japan</option>
						<option value="KZ">Kazakhstan</option>
						<option value="KW">Kuwait</option>
						<option value="KG">Kyrgyzstan</option>
						<option value="LA">Laos</option>
						<option value="LV">Latvia</option>
						<option value="LB">Lebanon</option>
						<option value="LT">Lithuania</option>
						<option value="LU">Luxembourg</option>
						<option value="MK">Macedonia</option>
						<option value="MY">Malaysia</option>
						<option value="MT">Malta</option>
						<option value="MX">Mexico</option>
						<option value="MD">Moldova</option>
						<option value="MC">Monaco</option>
						<option value="ME">Montenegro</option>
						<option value="MA">Morocco</option>
						<option value="NL">Netherlands</option>
						<option value="NZ">New Zealand</option>
						<option value="NI">Nicaragua</option>
						<option value="KP">North Korea</option>
						<option value="NO">Norway</option>
						<option value="PK">Pakistan</option>
						<option value="PS">Palestinian Territory</option>
						<option value="PE">Peru</option>
						<option value="PH">Philippines</option>
						<option value="PL">Poland</option>
						<option value="PT">Portugal</option>
						<option value="PR">Puerto Rico</option>
						<option value="QA">Qatar</option>
						<option value="RO">Romania</option>
						<option value="RU">Russia</option>
						<option value="SA">Saudi Arabia</option>
						<option value="RS">Serbia</option>
						<option value="SG">Singapore</option>
						<option value="SK">Slovakia</option>
						<option value="SI">Slovenia</option>
						<option value="ZA">South Africa</option>
						<option value="KR">South Korea</option>
						<option value="ES">Spain</option>
						<option value="LK">Sri Lanka</option>
						<option value="SE">Sweden</option>
						<option value="CH">Switzerland</option>
						<option value="TW">Taiwan</option>
						<option value="TH">Thailand</option>
						<option value="TN">Tunisia</option>
						<option value="TR">Turkey</option>
						<option value="UA">Ukraine</option>
						<option value="AE">United Arab Emirates</option>
						<option value="GB">United Kingdom</option>
						<option value="US">USA</option>
						<option value="UZ">Uzbekistan</option>
						<option value="VN">Vietnam</option>
					</select>
				</div>
			</div>
			<br>
			<button class='form-control btn btn-primary submit-button'
				type='submit'>Continue</button>
			<br>
	</form>
	<br>

	<div class="jumbotron jumbotron-flat">
		<div class="center">
			<h2>
				<i>BALANCE DUE:</i>
			</h2>
		</div>
		<div class="paymentAmt">${totalPrice}0</div>
	</div>
	<br>
	<br>
	<br>

</body>
<script type="text/javascript">
$(function() {
	  $('form.require-validation').bind('submit', function(e) {
		    var $form         = $(e.target).closest('form'),
		        inputSelector = ['input[type=email]', 'input[type=password]',
		                         'input[type=text]', 'input[type=file]',
		                         'textarea'].join(', '),
		        $inputs       = $form.find('.required').find(inputSelector),
		        $errorMessage = $form.find('div.error'),
		        valid         = true;

		    $errorMessage.addClass('hide');
		    $('.has-error').removeClass('has-error');
		    $inputs.each(function(i, el) {
		      var $input = $(el);
		      if ($input.val() === '') {
		        $input.parent().addClass('has-error');
		        $errorMessage.removeClass('hide');
		        e.preventDefault(); // cancel on first error
		      }
		    });
		  });
		});

		$(function() {
		  var $form = $("#payment-form");

		  $form.on('submit', function(e) {
		    if (!$form.data('cc-on-file')) {
		      e.preventDefault();
		      Stripe.setPublishableKey($form.data('stripe-publishable-key'));
		      Stripe.createToken({
		        number: $('.card-number').val(),
		        cvc: $('.card-cvc').val(),
		        exp_month: $('.card-expiry-month').val(),
		        exp_year: $('.card-expiry-year').val()
		      }, stripeResponseHandler);
		    }
		  });

		  function stripeResponseHandler(status, response) {
		    if (response.error) {
		      $('.error')
		        .removeClass('hide')
		        .find('.alert')
		        .text(response.error.message);
		    } else {
		      // token contains id, last4, and card type
		      var token = response['id'];
		      // insert the token into the form so it gets submitted to the server
		      $form.find('input[type=text]').empty();
		      $form.append("<input type='hidden' name='reservation[stripe_token]' value='" + token + "'/>");
		      $form.get(0).submit();
		    }
		  }
		})



		        $(document).ready(function() {

		            function loading() {
		                $('.paypalResult').show().html('<br><div class="alert alert-info">Please wait while we redirect you to PayPal to finish the checkout.</div>');
		            }

		            function formResult(data) {
		                $('.paypalResult').show().html('<br><div class="alert alert-success">Success: if you aren't redirected, hit the PayPal button.</div><meta http-equiv="refresh" content="2; url=https://paypal.ca">');
		                $('#paypalForm input').val('');
		            }

		            function onSubmit() {
		                $('#paypalForm').submit(function() {
		                    var action = $(this).attr('action');
		                    loading();
		                    $.ajax({
		                        url: action,
		                        type: 'POST',
		                        data: {
		                            token: $('#token').val(),
		                            action: $('#action').val()
		                        },
		                        success: function(data) {
		                            formResult(data);
		                        },
		                        error: function(data) {
		                            formResult(data);
		                        }
		                    });
		                    return false;
		                });
		            }
		            onSubmit();

		        });
</script>