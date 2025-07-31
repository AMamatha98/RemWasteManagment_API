# RemWasteManagement_RestAPI – Automated API Test Suite

This project is an automated API test suite built using **REST-assured** and **TestNG**. It validates basic CRUD operations against the public `https://crudcrud.com` RESTful API.

---

## ✅ What Is Being Tested?

This suite tests the following CRUD functionalities on a simple item resource (`/items`):

- **Create Items (POST)**
- **Read/Get Item(s) (GET)**
- **Update Item (PUT)**
- **Delete Item (DELETE)**
- Negative test cases (e.g., invalid payload, invalid IDs)

---

## 🧪 Test Coverage

| Test Class        | Coverage Description                        |
|------------------|---------------------------------------------|
| `CRUDE_POST.java` | Valid and invalid item creation             |
| `CRUDE_GET.java`  | Fetch single and all items                 |
| `CRUDE_UPDATE.java` | Update valid item, handle invalid ID     |
| `CRUDE_DELETE.java` | Delete valid item, handle invalid ID     |

All tests depend on data created dynamically at runtime and stored in a local file (`item_id.txt`).

---

## 🧰 Tools Used

| Tool          | Purpose                           |
|---------------|------------------------------------|
| REST-assured  | API automation framework           |
| TestNG        | Test orchestration and assertions  |
| Maven         | Build and dependency management    |
| Java 17       | Programming language               |

---

## 📂 Project Structure
RemWasteManagement_RestAPI/
│
├── src/
│ └── APITests/
│ ├── Base.java # Common setup (Base URI, path, shared data)
│ ├── CRUDE_POST.java # POST test cases
│ ├── CRUDE_GET.java # GET test cases
│ ├── CRUDE_UPDATE.java # PUT test cases
│ └── CRUDE_DELETE.java # DELETE test cases
│
├── item_id.txt # Temporary ID storage between tests
├── pom.xml # Maven config (dependencies, plugins)
├── testng.xml # TestNG suite config

---

## ▶️ How to Run the Tests

### Step 1: Clone the repository

```bash
git clone https://github.com/your-username/RemWasteManagement_RestAPI.git
cd RemWasteManagement_RestAPI

Step 2: Set the basePath in Base.java
Update the API token in RestAssured.basePath with your crudcrud.com API token:

RestAssured.basePath="/<your-token-here>";

Step 3: Run the test suite
You can run tests using Maven:

mvn clean test

Or by executing the testng.xml file directly from Eclipse/IDEA

**Assumptions and Limitations**
The API is stateless with no authentication (i.e., no login endpoint exists).

item_id.txt is used to persist item ID between tests.

The CRUD token expires after 24 hours. You must manually update it in Base.java.

Tests rely on correct execution order — defined via priority and dependsOnMethods
