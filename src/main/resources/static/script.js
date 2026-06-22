const API_URL = "http://localhost:8081/api/appliances";

document.addEventListener("DOMContentLoaded", () => {

    loadAppliances();
    loadTotalBill();

});

document
.getElementById("applianceForm")
.addEventListener("submit", async function(event){

    event.preventDefault();

    const appliance = {

        applianceName:
        document.getElementById("applianceName").value,

        watts:
        parseFloat(document.getElementById("watts").value),

        runningHours:
        parseFloat(document.getElementById("runningHours").value),

        daysUsed:
        parseInt(document.getElementById("daysUsed").value),

        costPerUnit:
        parseFloat(document.getElementById("costPerUnit").value)
    };

    await fetch(API_URL,{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
        },
        body:JSON.stringify(appliance)
    });

    document
    .getElementById("applianceForm")
    .reset();

    loadAppliances();
    loadTotalBill();
});

async function loadAppliances(){

    const response =
    await fetch(API_URL);

    const appliances =
    await response.json();

    const table =
    document.getElementById("applianceTable");

    table.innerHTML = "";

    appliances.forEach(appliance => {

        table.innerHTML += `
        <tr>
            <td>${appliance.id}</td>
            <td>${appliance.applianceName}</td>
            <td>${appliance.watts}</td>
            <td>${appliance.unitsConsumed}</td>
            <td>₹${appliance.totalCost}</td>
            <td>
                <button
                    class="delete-btn"
                    onclick="deleteAppliance(${appliance.id})">
                    Delete
                </button>
            </td>
        </tr>
        `;
    });
}

async function loadTotalBill(){

    const response =
    await fetch(API_URL + "/total");

    const total =
    await response.text();

    document
    .getElementById("totalBill")
    .innerText = total;
}

async function deleteAppliance(id){

    await fetch(API_URL + "/" + id,{
        method:"DELETE"
    });

    loadAppliances();
    loadTotalBill();
}