<%@ page language="java" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Shopping-cart</title>
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/style.css" />
    <link rel="stylesheet" href="css/reponsive.css" />
    <script type="text/javascript" src="resources/css/cart.js"></script>
</head>

<body>
    <!-- header -->
    <header>
        <nav>
            <div class="img-nav">
                <img src="img/logo.png" alt="" />
            </div>
            <div class="content-nav">
                <ul>
                    <li><a href="#">Trang Chủ</a></li>
                    <li><a href="#">Sản Phẩm</a></li>
                    <li><a href="#">Liên Hệ</a></li>
                    <li><a href="#">Giới Thiệu</a></li>
                </ul>
                <form>
                    <input type="text" name="search" placeholder="Tìm kiếm sản phẩm..." />
                    <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                </form>
            </div>
            <!-- The Modal -->
            <button id="cart">
                <i class="fa fa-shopping-basket" aria-hidden="true"></i>
                Giỏ Hàng
            </button>
            <div id="myModal" class="modal">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Giỏ Hàng</h5>
                        <span class="close">&times;</span>
                    </div>
                    <div class="modal-body">
                    <div class="cart-row">
                            
                        
                    
                        
                        <div class="cart-items">

                        </div>
                        <div class="cart-total">
                            <strong class="cart-total-title">Tổng Cộng:</strong>
                            <span class="cart-total-price">0VNĐ</span>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary close-footer">Đóng</button>
                        <button type="button" class="btn btn-primary order">Thanh Toán</button>
                    </div>
                </div>
            </div>
        </nav>

    </header>
    <!-- content -->
    <section class="wrapper">
        <div class="products">
            <ul>
                <li class="main-product">
                    <div class="img-product">
                        <img class="img-prd"
                            src="https://bizweb.dktcdn.net/thumb/large/100/228/168/products/sualai.jpg?v=1573720306000"
                            alt="">
                    </div>
                    <div class="content-product">
                        <h3 class="content-product-h3">Mũi Hàn 500</h3>
                        <div class="content-product-deltals">
                            <div class="price">
                                <span class="money">25000đ</span>
                            </div>
                            <button type="button" class="btn btn-cart">Thêm Vào Giỏ</button>
                        </div>
                    </div>
                </li>
                <li class="main-product">
                    <div class="img-product">
                        <img class="img-prd"
                            src="https://bizweb.dktcdn.net/thumb/large/100/228/168/products/sp1-57698689-e2c0-429a-bf4f-3bd0f39230d8.jpg?v=1575337954000"
                            alt="">
                    </div>
                    <div class="content-product">
                        <h3 class="content-product-h3">Trạm Hàn Hakko 942 75W 200-480*C 220VAC Cực Nóng</h3>
                        <div class="content-product-deltals">
                            <div class="price">
                                <span class="money">1299000đ</span>
                            </div>
                            <button type="button" class="btn btn-cart">Thêm Vào Giỏ</button>
                        </div>
                    </div>
                </li>
                <li class="main-product">
                    <div class="img-product">
                        <img class="img-prd"
                            src="https://bizweb.dktcdn.net/thumb/large/100/228/168/products/sp1-a45a32a1-38d4-4a8a-9c37-e936013858b2.jpg?v=1575877003000"
                            alt="">
                    </div>
                    <div class="content-product">
                        <h3 class="content-product-h3">Máy Bơm Chìm Hộ Gia Đình QDX 1500W 220VAC 40L/1min H=8m</h3>
                        <div class="content-product-deltals">
                            <div class="price">
                                <span class="money">1599000đ</span>
                            </div>
                            <button type="button" class="btn btn-cart">Thêm Vào Giỏ</button>
                        </div>
                    </div>
                </li>
                <li class="main-product no-margin">
                    <div class="img-product">
                        <img class="img-prd"
                            src="https://bizweb.dktcdn.net/thumb/large/100/228/168/products/module-diy-sac-khong-day-5.jpg?v=1570011041000"
                            alt="">
                    </div>
                    <div class="content-product">
                        <h3 class="content-product-h3">Module DIY Sạc Không Dây Qi IOS/Androi - Bộ phát V2</h3>
                        <div class="content-product-deltals">
                            <div class="price">
                                <span class="money">89000đ</span>
                            </div>
                            <button type="button" class="btn btn-cart">Thêm Vào Giỏ</button>
                        </div>
                    </div>
                </li>
                <li class="main-product">
                    <div class="img-product">
                        <img class="img-prd"
                            src="https://bizweb.dktcdn.net/thumb/large/100/228/168/products/bo-dieu-chinh-dien-ap-sdty-200p.jpg?v=1560155769920"
                            alt="">
                    </div>
                    <div class="content-product">
                        <h3 class="content-product-h3">Bộ Điều Chỉnh Điện Áp CHLVFU SDTY-200P 20KW 200A (BH 06 Tháng)
                        </h3>
                        <div class="content-product-deltals">
                            <div class="price">
                                <span class="money">2199000đ</span>
                            </div>
                            <button type="button" class="btn btn-cart">Thêm Vào Giỏ</button>
                        </div>
                    </div>
                </li>
                <li class="main-product">
                    <div class="img-product">
                        <img class="img-prd"
                            src="https://bizweb.dktcdn.net/thumb/large/100/228/168/products/isd1760-thu-am-thanh-phat-am-thanh-2.jpg?v=1568951032960"
                            alt="">
                    </div>
                    <div class="content-product">
                        <h3 class="content-product-h3">Module ISD1760 Thu Âm Thanh - Phát Âm Thanh 75s</h3>
                        <div class="content-product-deltals">
                            <div class="price">
                                <span class="money">115000đ</span>
                            </div>
                            <button type="button" class="btn btn-cart">Thêm Vào Giỏ</button>
                        </div>
                    </div>
                </li>
                <li class="main-product">
                    <div class="img-product">
                        <img class="img-prd"
                            src="https://bizweb.dktcdn.net/thumb/large/100/228/168/products/new-arrival-b-plus-64-bit-quad-2.jpg?v=1568277329707"
                            alt="">
                    </div>
                    <div class="content-product">
                        <h3 class="content-product-h3">Raspberry Pi 3 E14 Model B Plus B+ 2.4G/5G Bluetooth</h3>
                        <div class="content-product-deltals">
                            <div class="price">
                                <span class="money">1295000đ</span>
                            </div>
                            <button type="button" class="btn btn-cart">Thêm Vào Giỏ</button>
                        </div>
                    </div>
                </li>
                <li class="main-product no-margin">
                    <div class="img-product">
                        <img class="img-prd"
                            src="https://bizweb.dktcdn.net/thumb/large/100/228/168/products/module-iot-esp8266-esp-12e-ch340-3.jpg?v=1565950165000"
                            alt="">
                    </div>
                    <div class="content-product">
                        <h3 class="content-product-h3">Module IOT ESP8266 ESP-12E CH340 V3</h3>
                        <div class="content-product-deltals">
                            <div class="price">
                                <span class="money">85000đ</span>
                            </div>
                            <button type="button" class="btn btn-cart">Thêm Vào Giỏ</button>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </section>
    <!-- footer -->
    <footer>
        <div class="footer-item">
            <div class="img-footer">
                <img src="img/logo.png" alt="" />
            </div>
            <div class="social-footer">
                <li><a target="_blank" href="https://www.facebook.com/thanhlongdev">
                        <i class="fa fa-facebook-square" aria-hidden="true"></i>
                    </a></li>
                <li><a target="_blank" href="https://github.com/long1211">
                        <i class="fa fa-github-square" aria-hidden="true"></i>
                    </a></li>

            </div>
        </div>
    </footer>
 
	<script type="text/javascript">
	// Modal
	var modal = document.getElementById("myModal");
	var btn = document.getElementById("cart");
	var close = document.getElementsByClassName("close")[0];
	// tại sao lại có [0] như  thế này bởi vì mỗi close là một html colection nên khi mình muốn lấy giá trị html thì phải thêm [0]. 
	
	var close_footer = document.getElementsByClassName("close-footer")[0];
	var order = document.getElementsByClassName("order")[0];
	btn.onclick = function () {
	  modal.style.display = "block";
	}
	close.onclick = function () {
	  modal.style.display = "none";
	}
	close_footer.onclick = function () {
	  modal.style.display = "none";
	}
	order.onclick = function () {
	  alert("Cảm ơn bạn đã thanh toán đơn hàng")
	}
	window.onclick = function (event) {
	  if (event.target == modal) {
	    modal.style.display = "none";
	  }
	}
	//==========================
	// xóa cart
	var remove_cart = document.getElementsByClassName("btn-danger");
	for (var i = 0; i < remove_cart.length; i++) {
	  var button = remove_cart[i]
	  button.addEventListener("click", function () {
	    var button_remove = event.target
	    button_remove.parentElement.parentElement.remove()
	    updatecart()
	  })
	}	
	//===========
		// update cart 
	function updatecart() {
	  var cart_item = document.getElementsByClassName("cart-items")[0];
	  var cart_rows = cart_item.getElementsByClassName("cart-row");
	  var total = 0;
	  for (var i = 0; i < cart_rows.length; i++) {
	    var cart_row = cart_rows[i]
	    var price_item = cart_row.getElementsByClassName("cart-price ")[0]
	    var quantity_item = cart_row.getElementsByClassName("cart-quantity-input")[0]
	    var price = parseFloat(price_item.innerText)// chuyển một chuổi string sang number để tính tổng tiền.
	    var quantity = quantity_item.value // lấy giá trị trong thẻ input
	    total = total + (price * quantity)
	  }
	  document.getElementsByClassName("cart-total-price")[0].innerText = total + 'VNĐ'
	  // Thay đổi text = total trong .cart-total-price. Chỉ có một .cart-total-price nên mình sử dụng [0].
	}
	//===========
	// thay đổi số lượng sản phẩm
	var quantity_input = document.getElementsByClassName("cart-quantity-input");
	for (var i = 0; i < quantity_input.length; i++) {
	  var input = quantity_input[i];
	  input.addEventListener("change", function (event) {
	    var input = event.target
	    if (isNaN(input.value) || input.value <= 0) {
	      input.value = 1;
	    }
	    updatecart()
	  })
	}
	//==============
	var add_cart = document.getElementsByClassName("btn-cart");
	for (var i = 0; i < add_cart.length; i++) {
	  var add = add_cart[i];
	  add.addEventListener("click", function (event) {
	
	    var button = event.target;
	    var product = button.parentElement.parentElement;
	    var img = product.parentElement.getElementsByClassName("img-prd")[0].src
	    var title = product.getElementsByClassName("content-product-h3")[0].innerText
	    var price = product.getElementsByClassName("price")[0].innerText
	    addItemToCart(title, price, img)
	    // Khi thêm sản phẩm vào giỏ hàng thì sẽ hiển thị modal
	    modal.style.display = "block";
	    
	    updatecart()
	  })
	}
	
	
	
   </script>
</html>