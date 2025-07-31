"use client"

import type React from "react"

import { useState, useEffect, useRef } from "react"
import { gsap } from "gsap"
import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card"
import { Badge } from "@/components/ui/badge"
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar"
import { Search, Plus, Clock, Users, BookOpen, ArrowLeft, Edit, Trash2 } from "lucide-react"
import Link from "next/link"
import { skillOfferAPI } from "@/lib/api"
import { useAuth } from "@/hooks/useAuth"
import { ProtectedRoute } from "@/components/ProtectedRoute"

interface SkillOffer {
  id: string
  title: string
  description: string
  skillId: string
  skillName: string
  userId: string
  userName: string
  userAvatar?: string
  availability: string
  maxStudents: number
  currentStudents: number
  status: "active" | "paused" | "completed"
  createdAt: string
}

function OffersPageContent() {
  const [offers, setOffers] = useState<SkillOffer[]>([])
  const [filteredOffers, setFilteredOffers] = useState<SkillOffer[]>([])
  const [searchTerm, setSearchTerm] = useState("")
  const [isLoading, setIsLoading] = useState(true)
  const [selectedStatus, setSelectedStatus] = useState("all")

  const { user } = useAuth()
  const pageRef = useRef<HTMLDivElement>(null)
  const offersGridRef = useRef<HTMLDivElement>(null)

  useEffect(() => {
    const ctx = gsap.context(() => {
      // Page entrance animation
      const tl = gsap.timeline()

      tl.fromTo(".page-header", { opacity: 0, y: -30 }, { opacity: 1, y: 0, duration: 0.8, ease: "power3.out" })
        .fromTo(
          ".search-section",
          { opacity: 0, y: 20 },
          { opacity: 1, y: 0, duration: 0.6, ease: "power2.out" },
          "-=0.4",
        )
        .fromTo(
          ".offer-card",
          { opacity: 0, y: 50, scale: 0.9 },
          {
            opacity: 1,
            y: 0,
            scale: 1,
            duration: 0.6,
            stagger: 0.1,
            ease: "power3.out",
          },
          "-=0.3",
        )
    })

    return () => ctx.revert()
  }, [])

  useEffect(() => {
    fetchOffers()
  }, [])

  useEffect(() => {
    // Filter offers based on search and status
    let filtered = offers

    if (searchTerm) {
      filtered = filtered.filter(
        (offer) =>
          offer.title.toLowerCase().includes(searchTerm.toLowerCase()) ||
          offer.description.toLowerCase().includes(searchTerm.toLowerCase()) ||
          offer.skillName.toLowerCase().includes(searchTerm.toLowerCase()) ||
          offer.userName.toLowerCase().includes(searchTerm.toLowerCase()),
      )
    }

    if (selectedStatus !== "all") {
      filtered = filtered.filter((offer) => offer.status === selectedStatus)
    }

    setFilteredOffers(filtered)

    // Animate filtered results
    if (offersGridRef.current) {
      gsap.fromTo(
        ".offer-card",
        { opacity: 0, y: 30 },
        {
          opacity: 1,
          y: 0,
          duration: 0.5,
          stagger: 0.05,
          ease: "power2.out",
        },
      )
    }
  }, [searchTerm, selectedStatus, offers])

  const fetchOffers = async () => {
    try {
      setIsLoading(true)
      const response = await skillOfferAPI.getOffers()
      setOffers(response.data)
    } catch (error) {
      console.error("Failed to fetch offers:", error)
      // Mock data for demo
      setOffers([
        {
          id: "1",
          title: "React Development Mentorship",
          description: "Learn modern React patterns and best practices through hands-on projects",
          skillId: "1",
          skillName: "React Development",
          userId: "1",
          userName: "Sarah Chen",
          availability: "Weekends",
          maxStudents: 5,
          currentStudents: 3,
          status: "active",
          createdAt: "2024-01-15",
        },
        {
          id: "2",
          title: "UI/UX Design Workshop",
          description: "Master design principles and create stunning user interfaces",
          skillId: "2",
          skillName: "UI/UX Design",
          userId: "2",
          userName: "Mike Johnson",
          availability: "Evenings",
          maxStudents: 8,
          currentStudents: 6,
          status: "active",
          createdAt: "2024-01-10",
        },
      ])
    } finally {
      setIsLoading(false)
    }
  }

  const handleDeleteOffer = async (offerId: string) => {
    try {
      await skillOfferAPI.deleteOffer(offerId)
      setOffers(offers.filter((offer) => offer.id !== offerId))
    } catch (error) {
      console.error("Failed to delete offer:", error)
    }
  }

  const handleCardHover = (e: React.MouseEvent<HTMLDivElement>) => {
    gsap.to(e.currentTarget, {
      y: -8,
      scale: 1.02,
      duration: 0.3,
      ease: "power2.out",
    })
  }

  const handleCardLeave = (e: React.MouseEvent<HTMLDivElement>) => {
    gsap.to(e.currentTarget, {
      y: 0,
      scale: 1,
      duration: 0.3,
      ease: "power2.out",
    })
  }

  const statusOptions = [
    { value: "all", label: "All Status" },
    { value: "active", label: "Active" },
    { value: "paused", label: "Paused" },
    { value: "completed", label: "Completed" },
  ]

  if (isLoading) {
    return (
      <div className="min-h-screen flex items-center justify-center">
        <div className="w-8 h-8 border-2 border-blue-600 border-t-transparent rounded-full animate-spin" />
      </div>
    )
  }

  return (
    <div ref={pageRef} className="min-h-screen bg-gradient-to-br from-blue-50 via-white to-purple-50">
      {/* Navigation */}
      <nav className="bg-white/80 backdrop-blur-md border-b sticky top-0 z-50">
        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
          <div className="flex justify-between items-center h-16">
            <div className="flex items-center space-x-4">
              <Link href="/dashboard" className="flex items-center text-gray-600 hover:text-gray-900">
                <ArrowLeft className="w-5 h-5 mr-2" />
                Back
              </Link>
              <div className="flex items-center space-x-2">
                <div className="w-8 h-8 bg-gradient-to-r from-green-600 to-blue-600 rounded-lg flex items-center justify-center">
                  <BookOpen className="w-5 h-5 text-white" />
                </div>
                <span className="text-xl font-bold bg-gradient-to-r from-green-600 to-blue-600 bg-clip-text text-transparent">
                  Skill Offers
                </span>
              </div>
            </div>
            <Link href="/offers/create">
              <Button className="bg-gradient-to-r from-green-600 to-blue-600 hover:from-green-700 hover:to-blue-700">
                <Plus className="w-4 h-4 mr-2" />
                Create Offer
              </Button>
            </Link>
          </div>
        </div>
      </nav>

      <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
        {/* Header */}
        <div className="page-header text-center mb-12">
          <h1 className="text-5xl font-bold text-gray-900 mb-4">
            Skill{" "}
            <span className="bg-gradient-to-r from-green-600 to-blue-600 bg-clip-text text-transparent">Offers</span>
          </h1>
          <p className="text-xl text-gray-600 max-w-2xl mx-auto">
            Browse available skill sharing opportunities from our community
          </p>
        </div>

        {/* Search and Filter */}
        <div className="search-section mb-8">
          <div className="flex flex-col md:flex-row gap-4 items-center justify-between">
            <div className="relative flex-1 max-w-md">
              <Search className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400 w-5 h-5" />
              <Input
                placeholder="Search offers, skills, or instructors..."
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
                className="pl-10 h-12 border-2 focus:border-blue-500"
              />
            </div>

            <div className="flex gap-2 flex-wrap">
              {statusOptions.map((status) => (
                <Button
                  key={status.value}
                  variant={selectedStatus === status.value ? "default" : "outline"}
                  onClick={() => setSelectedStatus(status.value)}
                  className={
                    selectedStatus === status.value
                      ? "bg-gradient-to-r from-green-600 to-blue-600"
                      : "hover:bg-gray-100"
                  }
                >
                  {status.label}
                </Button>
              ))}
            </div>
          </div>
        </div>

        {/* Offers Grid */}
        <div ref={offersGridRef} className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
          {filteredOffers.map((offer) => (
            <Card
              key={offer.id}
              className="offer-card border-0 shadow-lg hover:shadow-xl transition-shadow duration-300 cursor-pointer"
              onMouseEnter={handleCardHover}
              onMouseLeave={handleCardLeave}
            >
              <CardHeader className="pb-4">
                <div className="flex items-center justify-between mb-3">
                  <Badge
                    variant={offer.status === "active" ? "default" : "secondary"}
                    className={offer.status === "active" ? "bg-green-100 text-green-700" : ""}
                  >
                    {offer.status}
                  </Badge>
                  {user?.id === offer.userId && (
                    <div className="flex space-x-1">
                      <Button size="sm" variant="outline">
                        <Edit className="w-4 h-4" />
                      </Button>
                      <Button
                        size="sm"
                        variant="outline"
                        onClick={() => handleDeleteOffer(offer.id)}
                        className="text-red-600 hover:text-red-700"
                      >
                        <Trash2 className="w-4 h-4" />
                      </Button>
                    </div>
                  )}
                </div>
                <CardTitle className="text-xl mb-2">{offer.title}</CardTitle>
                <CardDescription className="text-gray-600 line-clamp-2">{offer.description}</CardDescription>
              </CardHeader>

              <CardContent>
                <div className="flex items-center space-x-3 mb-4">
                  <Avatar className="w-10 h-10">
                    <AvatarImage src={offer.userAvatar || "/placeholder.svg"} />
                    <AvatarFallback>
                      {offer.userName
                        .split(" ")
                        .map((n) => n[0])
                        .join("")}
                    </AvatarFallback>
                  </Avatar>
                  <div>
                    <p className="font-medium text-gray-900">{offer.userName}</p>
                    <p className="text-sm text-gray-600">{offer.skillName}</p>
                  </div>
                </div>

                <div className="space-y-2 mb-4">
                  <div className="flex items-center justify-between text-sm text-gray-600">
                    <div className="flex items-center">
                      <Clock className="w-4 h-4 mr-1" />
                      {offer.availability}
                    </div>
                    <div className="flex items-center">
                      <Users className="w-4 h-4 mr-1" />
                      {offer.currentStudents}/{offer.maxStudents}
                    </div>
                  </div>

                  <div className="w-full bg-gray-200 rounded-full h-2">
                    <div
                      className="bg-gradient-to-r from-green-600 to-blue-600 h-2 rounded-full"
                      style={{ width: `${(offer.currentStudents / offer.maxStudents) * 100}%` }}
                    />
                  </div>
                </div>

                <div className="flex items-center justify-between">
                  <span className="text-sm text-gray-500">
                    Created {new Date(offer.createdAt).toLocaleDateString()}
                  </span>
                  <Button
                    size="sm"
                    className="bg-gradient-to-r from-green-600 to-blue-600 hover:from-green-700 hover:to-blue-700 text-white"
                    disabled={offer.currentStudents >= offer.maxStudents}
                  >
                    {offer.currentStudents >= offer.maxStudents ? "Full" : "Join"}
                  </Button>
                </div>
              </CardContent>
            </Card>
          ))}
        </div>

        {/* Empty State */}
        {filteredOffers.length === 0 && (
          <div className="text-center py-16">
            <div className="w-24 h-24 bg-gray-100 rounded-full flex items-center justify-center mx-auto mb-6">
              <Search className="w-12 h-12 text-gray-400" />
            </div>
            <h3 className="text-2xl font-bold text-gray-900 mb-2">No offers found</h3>
            <p className="text-gray-600 mb-6">Try adjusting your search terms or browse different statuses</p>
            <Button
              onClick={() => {
                setSearchTerm("")
                setSelectedStatus("all")
              }}
              variant="outline"
            >
              Clear Filters
            </Button>
          </div>
        )}
      </div>
    </div>
  )
}

export default function OffersPage() {
  return (
    <ProtectedRoute>
      <OffersPageContent />
    </ProtectedRoute>
  )
}
