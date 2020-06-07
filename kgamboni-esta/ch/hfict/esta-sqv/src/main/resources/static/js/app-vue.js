
Vue.use(DataTable) 

Vue.config.productionTip = false

Vue.component('App', {
});


/* eslint-disable no-new */

new Vue({
    el: '#app',
  data: {
	  gridColumns: ['firstname', 'lastname', 'birthdate', 'action'],
	  gridData: [{}],
	  student: {
		  firstname:'',
		  lastname:'',
		  birthdate:'',
		  _links:''},
	  errors: []
  },
	template: `
	<div>
	<div class="form-group row">
	  <label for="firstname" class="col-sm-2 col-form-label">First Name:</label>
	  <div class="col-sm-8" >
 	    <input id="firstname" v-model="student.firstname" type="text" class="form-control"/>
	  </div>
	</div>
	<div class="form-group row">
	  <label class="col-sm-2 control-label">Last Name:</label>
	  <div class="col-sm-8" >
 	    <input id="firstname" v-model="student.lastname" type="text" class="form-control"/>
	  </div>
	</div>
	<div class="form-group row">
	  <label for="birthdate" class="col-sm-2 col-form-label">Birthdate:</label>
	  <div class="col-sm-3" >
 	    <input id="birthdate" v-model="student.birthdate" type="date" class="form-control"/>
	  </div>
	</div>
	<div class="form-group">
	  <button type="submit" class="btn btn-primary submit" v-on:click="save">Save</button>
	</div>
		<div class="datatable">    
	    <data-table :data="gridData" :columns-to-display="gridColumns"> 
	       <template slot="action" scope="props">
      		<button v-on:click="edit(props.entry._links.self.href)">
        		Edit
      		</button>
    		</template>
	    </data-table>
       </div>
     </div>`,
    
methods: {
    findall: function() {
    	axios.get(`/api/students`)
    	.then(response => {
    		// JSON responses are automatically parsed.
    		this.gridData = response.data._embedded.students;
    	})
    	.catch(e => {
    		this.errors.push(e);
    	})},
    	
    edit: function(id){
    	console.log(id);
        axios.get(id)
        .then(response => {
        	this.student = response.data;
        })
        .catch(e => {
        	this.errors.push(e);
     })},
     
     save() {
    	 console.log(this.student._links.self.href);
         let data = JSON.stringify({
             firstname: this.student.firstname,
             lastname: this.student.lastname,
             birthdate: this.student.birthdate
         });
    	 axios.put(this.student._links.self.href, data, {
    		 headers: {
    	            'Content-Type': 'application/json'
    	        }})
    	 .then(function(response){ console.log(response); });
     }
},

mounted: function(){
	this.findall()
}

});
