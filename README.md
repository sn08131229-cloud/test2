# 生物医药/医疗器械流转多方查验平台 V1

## 为什么你会看到“localhost:5173 无法访问”
通常是前端服务未启动或依赖未安装。请按顺序执行：
```bash
cd frontend
npm install
npm run dev
```
本项目已固定 dev 启动为 `vite --host 0.0.0.0 --port 5173`，确保浏览器可访问。

## 启动方式
### 前端（VS Code）
```bash
cd frontend
npm install
npm run dev
```
默认: http://localhost:5173

### 后端（IntelliJ IDEA）
1. 用 IDEA 打开 `backend`。
2. 选择主类 `com.example.trace.TraceApplication` 直接运行。
3. 或命令行：
```bash
cd backend
mvn spring-boot:run
```
默认: http://localhost:8080

## 配置文件
- `backend/src/main/resources/application-dev.yml`
  - `server.port=8080`
  - `spring.datasource.url=jdbc:mysql://localhost:3306/medical_device_trace`
  - `spring.datasource.username=root`
  - `spring.datasource.password=your_password`
  - `chain.mock=true|false`
  - `chain.webaseFrontUrl=http://虚拟机IP:5002/WeBASE-Front`
  - `chain.groupId=1`
  - `chain.contractAddress=合约地址`
- `frontend/.env.development`
  - `VITE_API_BASE_URL=http://localhost:8080/api`

## MySQL 初始化
SQL 文件：
- `backend/src/main/resources/sql/init.sql`
- `docs/sql/init.sql`

执行：
```sql
source /path/to/init.sql;
```

## 已实现接口（V1）
- 登录：`POST /api/login`
- 设备：`GET/POST /api/devices`、`GET /api/devices/{deviceCode}`、`GET /api/devices/{deviceCode}/flows`
- 采购：`POST /api/purchase/apply|approve|reject|receive`、`GET /api/purchase/list`
- 借用：`POST /api/borrow/apply|approve|reject|lend|receive|return/apply|return/confirm`、`GET /api/borrow/list`
- 流转：`GET /api/flows`、`GET /api/flows/byTxHash/{txHash}`、`GET /api/flows/verify/{flowId}`
- 仪表盘：`GET /api/dashboard/stats`

## 账号
- admin/admin123
- regulator/reg123
- supplier1/sup123
- supplier2/sup123
- hospital1/hos123
- hospital2/hos123
- hospital3/hos123

## Mock 与真实链切换
- `chain.mock=true`：使用 MockChainService（默认）
- `chain.mock=false`：切换 RealChainService（需要接入 WeBASE-Front/FISCO BCOS）

## 端口/地址
- 前端: http://localhost:5173
- 后端: http://localhost:8080
- MySQL: localhost:3306
- WeBASE-Front: http://虚拟机IP:5002/WeBASE-Front

## 合约（已补充）
- 合约文件：`contract/DeviceTrace.sol`
- 已实现方法：
  - `registerDevice`
  - `addFlowRecord`
  - `getDeviceFlowCount`
  - `getDeviceFlowByIndex`
  - `getLatestDeviceStatus`

说明：当前后端默认走 `MockChainService`，你在 Ubuntu 虚拟机启动 WeBASE/FISCO 后，可按该合约部署并把地址填入 `chain.contractAddress`。
