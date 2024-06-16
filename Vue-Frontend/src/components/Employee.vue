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
      </div>
    </div>
  </template>
    
    <script>
    
    
    import axios from 'axios';
    
     
      export default {
        name: 'RegistationForm',
        data () {
          return {
            result: {},
            employee:{
                       id: '',
                       employeename: '',
                       address: '',
                       mobile: ''
            }
          }
        },
        created() { 
        },
        mounted() {
              console.log("mounted() called.......");
          },
        methods: {
               saveData()
               {
                axios.post("http://localhost:8085/api/v1/employee/save", this.employee)
                .then(
                  
                    alert("Details Submitted...!")
                  
                )
               }
          }
      }
    
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
  text-align: center;
  width: 100%;
}

h2 {
  margin-bottom: 20px;
}

.btn-primary {
  display: block;
  margin: 0 auto;
}
</style>