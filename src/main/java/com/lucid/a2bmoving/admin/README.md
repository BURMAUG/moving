#README
An admin can have a lot of customers and a customer can have only one admin

#this should be implemented
    @GetMapping("/customer")
    public List<Customer> getCustomer()
    {
        Customer re = customerRepository.findCustomerByCustomer_first_name("Burmau");
        logger.info(String.valueOf(re));
        return (List<Customer>) customerRepository.findAll();
    }
    @GetMapping("/in-progress")
    private List<OnDuty> getActiveServices(){
        return new ArrayList<OnDuty>();
    }

    @GetMapping("/completed")
    public List<CompletedTasks> getCompletedTasks()
    {
        return new Array<CompleteTasks>();
    }

    @PostMapping("/pending")
    public List<Pending> getPendingServices(){
        return new ArrayList<PendingServices>();
    }
