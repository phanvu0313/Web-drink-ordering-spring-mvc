
	function addItemToCart(title, price, img) {
		  var cartRow = document.createElement('div')
		  cartRow.classList.add('cart-row')
		  var cartItems = document.getElementsByClassName('cart-items')[0]
		  var cart_title = cartItems.getElementsByClassName('cart-item-title')
		  
		  for (var i = 0; i < cart_title.length; i++) {
		    if (cart_title[i].innerText == title) {
		      alert('San pham da duoc them vao gio hang')
		      return
		    }
		  }

		  var cartRowContents = `
		  <div class="cart-item cart-column">
		      <img class="cart-item-image" src="${img}" width="100" height="100">
		      <span class="cart-item-title">${title}</span>
		  </div>
		  <span class="cart-price cart-column">${price}</span>
		  <div class="cart-quantity cart-column">
		      <input class="cart-quantity-input" type="number" value="1"  style="width: 87px;">
		      <button class="btn btn-danger" type="button">Del</button>
		  </div>`
		 
		  cartRow.innerHTML = cartRowContents
		  cartItems.append(cartRow)
		  cartRow.getElementsByClassName('btn-danger')[0].addEventListener('click', function () {
		    var button_remove = event.target
		    button_remove.parentElement.parentElement.remove()
		    updatecart()
		  })
		  cartRow.getElementsByClassName('cart-quantity-input')[0].addEventListener('change', function (event) {
		    var input = event.target
		    if (isNaN(input.value) || input.value <= 0) {
		      input.value = 1;
		    }
		    updatecart()
		  })
		}