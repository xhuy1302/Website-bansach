/**
 * 
 */document.getElementById("addToCartBtn").addEventListener("click", function() {
    var form = document.getElementById("addToCartForm");
    var formData = new FormData(form);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", form.action, true); // form.action chứa đường dẫn đến Servlet ("/addGioHang")
    
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            try {
                var response = JSON.parse(xhr.responseText);
                console.log(response); // Xem thông tin giỏ hàng trong console (nếu cần)

                // Xử lý giỏ hàng sau khi thêm sản phẩm thành công
                alert("Sản phẩm đã được thêm vào giỏ hàng!");

                // Bạn có thể cập nhật giao diện giỏ hàng mà không cần reload trang
                updateCartDisplay(response); // Hàm giả định để cập nhật giỏ hàng trên giao diện
            } catch (e) {
                alert("Có lỗi xảy ra khi thêm sản phẩm vào giỏ hàng.");
            }
        }
    };
    
    xhr.send(formData);
});

// Hàm giả định để cập nhật giao diện giỏ hàng
function updateCartDisplay(cart) {
    // Ví dụ: Cập nhật phần giỏ hàng trên giao diện người dùng
    var cartCountElement = document.getElementById("cartCount");
    cartCountElement.innerText = cart.length; // Cập nhật số lượng sản phẩm trong giỏ
}
