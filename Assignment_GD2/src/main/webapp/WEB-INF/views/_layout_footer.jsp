</main>
<footer style="padding:16px;margin-top:24px;background:#333;color:#fff;border-top:1px solid rgba(255,255,255,.15)">
    @2025 LibrarySystem
</footer>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        document.querySelectorAll('form.borrow-form').forEach(function (form) {
            form.addEventListener('submit', function (e) {
                const btn = form.querySelector('button[type="submit"], button:not([type])');
                if (btn.disabled) {
                    e.preventDefault();
                    alert('Bạn đã gửi yêu cầu mượn rồi, vui lòng đợi...');
                    return false;
                }
                btn.disabled = true;
                btn.setAttribute('aria-busy', 'true');
                btn.dataset.originalText = btn.textContent;
                btn.textContent = 'Đang xử lý...';
            });
        });
    });
</script>
</body>
</html>