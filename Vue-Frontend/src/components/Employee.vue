<template>
  <div class="container">
    <div class="row">
      <h2 align="center">Employee Registration</h2>
      <div class="col-sm-6">
        <form @submit.prevent="saveData">
          <div class="form-group">
            <label>Employee Name</label>
            <input
              type="text"
              v-model="employee.employeename"
              class="form-control"
              placeholder="Enter Name"
            />
          </div>

          <div class="form-group">
            <label>Address</label>
            <input
              type="text"
              v-model="employee.address"
              class="form-control"
              placeholder="Enter Address"
            />
          </div>

          <div class="form-group">
            <label>Mobile</label>
            <input
              type="text"
              v-model="employee.mobile"
              class="form-control"
              placeholder="Enter Mobile"
            />
          </div>

          <br />
          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
      </div>
      <h1 class="text-center"> Employee List</h1>

<table class=" table table-striped">
<thead>
  <th> Employee ID</th>
  <th> Employee Name</th>
  <th> Employee Address</th>
  <th> Employee Mobile No.</th>
  
</thead>

  <tbody>
      <tr v-for="employee in employees" v-bind:key = "employee.employeeid">
          <td>{{ employee.employeeid }}</td>
          <td>{{ employee.employeename }}</td>
          <td>{{ employee.address }}</td>
          <td>{{ employee.mobile }}</td>
      </tr>
  </tbody>

</table>

  </div>

    </div>
    
</template>

<script>
import axios from 'axios';

export default {
  name: 'RegistrationForm',
  data() {
    return {
      result: {},
      employee: {
        id: '',
        employeename: '',
        address: '',
        mobile: ''
      },
      employees: []
    };
  },
  mounted() {
    console.log("mounted() called.......");
    this.getEmployees();
  },
  methods: {
    saveData() {
      axios.post("http://localhost:8085/api/v1/employee/save", this.employee)
        .then(
          alert("Details Submitted...!")
          )
        .catch(error => {
          console.error("There was an error submitting the form!", error);
        });
    },
    getEmployees() {
      axios.get("http://localhost:8085/api/v1/employee/get")
        .then(response => {
          this.employees = response.data;
        })
        .catch(error => {
          console.error("There was an error fetching the employee data!", error);
        });
    }
  }
};
</script>

<style scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh; /* Adjust height as needed */
  flex-direction: column;
}

.row {
  width: 100%;
  max-width: 600px; /* Adjust width as needed */
}

.form-group {
  text-align: left;
  width: 100%;
}

h2 {
  margin-bottom: 20px;
}

.btn-primary {
  display: block;
  margin: 0 auto;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin: 5px 0;
}
</style>
