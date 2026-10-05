import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankManager manager = new BankManager();
        Scanner scanner = new Scanner(System.in);

        // Nạp dữ liệu mẫu
        try {
            SavingAccount acc1 = new SavingAccount("STK001", "Nguyen Van A", 500000.0, 5.5);
            SavingAccount acc2 = new SavingAccount("STK002", "Tran Thi B", 200000.0, 6.0);
            manager.addAccount(acc1);
            manager.addAccount(acc2);
        } catch (Exception e) {
            System.err.println("Lỗi tạo dữ liệu mẫu: " + e.getMessage());
        }

        while (true) {
            System.out.println("\n========== HỆ THỐNG QUẢN LÝ NGÂN HÀNG ==========");
            System.out.println("1. Xem danh sách tài khoản");
            System.out.println("2. Nạp tiền vào tài khoản");
            System.out.println("3. Rút tiền từ tài khoản");
            System.out.println("4. Chuyển tiền");
            System.out.println("5. Tính tổng số dư hệ thống (Generics Wildcard)");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            String choice = scanner.nextLine();
            try {
                switch (choice) {
                    case "1":
                        System.out.println("\n--- DANH SÁCH TÀI KHOẢN ---");
                        for (BankAccount acc : manager.getAllAccounts()) {
                            System.out.println(acc);
                        }
                        break;
                    case "2":
                        System.out.print("Nhập số tài khoản: ");
                        String depAccNum = scanner.nextLine();
                        BankAccount depAcc = manager.findAccount(depAccNum);
                        if (depAcc == null) {
                            System.out.println("Lỗi: Không tìm thấy tài khoản!");
                            break;
                        }
                        System.out.print("Nhập số tiền nạp: ");
                        double depAmount = Double.parseDouble(scanner.nextLine());
                        depAcc.deposit(depAmount);
                        System.out.println(">> Nạp tiền thành công! " + depAcc);
                        break;
                    case "3":
                        System.out.print("Nhập số tài khoản: ");
                        String withAccNum = scanner.nextLine();
                        BankAccount withAcc = manager.findAccount(withAccNum);
                        if (withAcc == null) {
                            System.out.println("Lỗi: Không tìm thấy tài khoản!");
                            break;
                        }
                        System.out.print("Nhập số tiền rút: ");
                        double withAmount = Double.parseDouble(scanner.nextLine());
                        withAcc.withdraw(withAmount);
                        System.out.println(">> Rút tiền thành công! " + withAcc);
                        break;
                    case "4":
                        System.out.print("Nhập số tài khoản nguồn: ");
                        String fromAcc = scanner.nextLine();
                        System.out.print("Nhập số tài khoản đích: ");
                        String toAcc = scanner.nextLine();
                        System.out.print("Nhập số tiền chuyển: ");
                        double transferAmount = Double.parseDouble(scanner.nextLine());

                        manager.transferMoney(fromAcc, toAcc, transferAmount);
                        System.out.println(">> Chuyển tiền thành công!");
                        break;
                    case "5":
                        double total = manager.calculateTotalBalance(manager.getAllAccounts());
                        System.out.printf(">> Tổng số dư toàn bộ hệ thống: %,.2f VNĐ\n", total);
                        break;
                    case "0":
                        System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại!");
                }
            } catch (InvalidAmountException | InsufficientBalanceException e) {
                System.err.println(">>> LỖI NGHIỆP VỤ: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println(">>> LỖI ĐỊNH DẠNG: Vui lòng nhập đúng giá trị số!");
            } catch (Exception e) {
                System.err.println(">>> LỖI HỆ THỐNG: " + e.getMessage());
            }
        }
    }
}

